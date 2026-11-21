package org.example;

public class ScoringStratégy implements Strategy{
    private double solde=0;


    @Override
    public void traiterNotification(Transaction transaction) {
         if(transaction.getType().equals(TransactionType.VENTE)){
             solde=solde+transaction.getMontant();
         }else{
             solde=solde-transaction.getMontant();
         }

        System.out.println("********** ScoringStratégy ****************");
        System.out.println("Solde Actuelle:"+ solde);
        System.out.println("*******************************************");
    }
}
