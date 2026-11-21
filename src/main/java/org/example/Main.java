package org.example;

import org.example.aspects.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


import java.util.Date;
import java.util.UUID;

@ComponentScan(basePackages = "org.example")

public class Main {
    public static void main(String[] args) {
       Transaction transaction = Transaction.builder()
               .id(UUID.randomUUID().toString())
               .date(new Date())
               .montant(Math.random()*1000+4000)
               .type(Math.random()<0.5?TransactionType.VENTE:TransactionType.ACHAT)
               .build();

        System.out.println(transaction);

        Transaction transaction2 = Transaction.builder()
                .id(UUID.randomUUID().toString())
                .date(new Date())
                .montant(Math.random()*1000+4000)
                .type(Math.random()<0.5?TransactionType.VENTE:TransactionType.ACHAT)
                .build();


        Agent agent1 = new Agent();
        agent1.setId(1L);
        agent1.setNom("Agent1");
        Agent agent2 = new Agent();
        agent2.setId(2L);
        agent2.setNom("Agent2");
        Agent agent3 = new Agent();
        agent3.setId(3L);
        agent3.setNom("Agent3");

        agent1.subscribe(agent2);
        agent1.subscribe(agent3);
        agent1.addTransaction(transaction);

        System.out.println("\n");
        agent1.setStrategy(new ScoringStratégy());
        agent1.unsubscribe(agent2);

        agent1.addTransaction(transaction2);

        System.out.println("\n");
        agent1.setStrategy(new HistotyStrategy());
       agent1.unsubscribe(agent3);
        agent1.addTransaction(transaction2);


        //afficher le nom
       System.out.println("Nom : "+agent1.getNom());

        //afficher les transactions
        agent1.getTransactions();

        //la transaction  avec le plus grand montant
       System.out.println("la transaction géré par l'Agent 1 avec le plus grand montant est :" +agent1.maxTransactionMontant());



     Conteneur conteneur = Conteneur.getInsance();
     //ajout
     conteneur.addAgent(agent1);
     conteneur.addAgent(agent2);
     conteneur.addAgent(agent3);
     //suppression
     conteneur.removeAgent(agent1);
     //recherche
     conteneur.searchAgent("Agent1");

     conteneur.setHdmi(new AfficheurHdmi1());
     conteneur.afficher();
     conteneur.setHdmi(new AfficheurHdmi2());
     conteneur.afficher();

     Adapter adapter = new Adapter();
     adapter.setVga(new AfficheurVGA());


     conteneur.setHdmi(new Adapter());

     conteneur.afficher();


    //log aspect

     ApplicationContext context =
             new AnnotationConfigApplicationContext(Main.class);


     Strategy strategy = context.getBean(Strategy.class);
     strategy.traiterNotification(transaction);


     Agent agent = context.getBean(Agent.class);

     agent.setId(1L);
     agent.setNom("Agent1");

     agent.subscribe(agent2);


     // security aspect
     try {
      SecurityContext.authenticate("root","1234",new String[]{"USER"});
      agent.setStrategy(new ScoringStratégy());
     }catch (Exception e){
      System.out.println(e.getMessage());
     }



    }






    }







