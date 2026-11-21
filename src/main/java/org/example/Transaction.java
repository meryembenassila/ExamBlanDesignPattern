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

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
