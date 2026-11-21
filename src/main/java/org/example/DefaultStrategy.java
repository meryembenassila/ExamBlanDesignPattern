package org.example;

public class DefaultStrategy implements Strategy {

    @Override
    public void traiterNotification(Transaction transaction) {
        System.out.println("********** DefaultStrategy ****************");
        System.out.println("Transaction a traité :"+transaction);
        System.out.println("*******************************************");
    }
}
