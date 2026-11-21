package org.example;

import java.util.Date;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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


        Agent agent1 = new Agent(1L,"Agent1");
        Agent agent2 = new Agent(2L,"Agent2");
        Agent agent3 = new Agent(3L,"Agent3");

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


    }









}