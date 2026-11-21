package org.example;

import java.util.Date;

public class Transaction {
    private String id ;
    private Date date;
    private double montant;
    private TransactionType type;

    public   static class  TransactionBuilder{
        Transaction transaction = new Transaction();

        public TransactionBuilder id(String id){
            transaction.id=id;
            return this;
        }

        public TransactionBuilder date(Date date){
            transaction.date=date;
            return this;
        }

        public TransactionBuilder montant(double montant){
            transaction.montant=montant;
            return this;
        }

        public TransactionBuilder type(TransactionType transactionType){
            transaction.type=transactionType;
            return this;
        }

        public Transaction build(){
            return this.transaction;
        }



    }
    public static TransactionBuilder builder(){
        return new TransactionBuilder();
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", montant=" + montant +
                ", date='" + date  +
                ", type=" + type +
                '}';
    }




}
