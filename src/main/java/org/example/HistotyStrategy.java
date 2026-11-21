package org.example;

import java.util.List;

public class HistotyStrategy implements Strategy{
    List<Transaction> transactions;

    @Override
    public void traiterNotification(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("********** HistotyStrategy ****************");
        System.out.println("Historique des transaction");
        transactions.forEach(transaction1 -> System.out.println(transaction1));
        System.out.println("*******************************************");
    }

}
