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
        agent1.unsubscribe(agent3);
        agent1.setStrategy(new HistotyStrategy());
        agent1.addTransaction(transaction2);

    }






}