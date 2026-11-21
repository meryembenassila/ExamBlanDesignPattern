package org.example;

import java.util.ArrayList;
import java.util.List;

public class Agent {
    //attributs
    private Long id;
    private String nom;
    private List<Transaction> transactions ;
    private Strategy strategy = new DefaultStrategy();
    private List<Agent> observateurs ;

    //constructeur
    public Agent(Long id, String nom) {
        this.id = id;
        this.nom = nom;
        this.transactions = new ArrayList<>();
        this.observateurs = new ArrayList<>();
    }


    //getters
    public Long getId() {
        return id;
    }
    //afficher le nom
    public void getNom() {
        System.out.println( "Nom de l'agent : "+  nom);
    }
    //afficher les transactions
    public void getTransactions() {
        System.out.println("Transactions  géré par l'agent "+nom+ " sont  : \n");
        transactions.forEach(transaction -> System.out.println(transaction));
    }



    //setters
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    //une opération qui calcule et retourne la transaction qui a le montant le plus grand.

public Transaction maxTransactionMontant(){
        int  index=0;
        double max = transactions.get(index).getMontant();

    for (int i = 1; i < transactions.size(); i++) {
        if (transactions.get(i).getMontant()>max){
            index=i;
        }
    }

 return transactions.get(index);
}

//observable
    public void subscribe(Agent agent) {
        observateurs.add(agent);

    }

    public void unsubscribe(Agent agent) {
        observateurs.remove(agent);
    }

    public void notifyObservers(Transaction transaction) {
        observateurs.forEach(agent -> {
            agent.update(this.nom,transaction);
        });
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        notifyObservers(transaction);
        strategy.traiterNotification(transaction);
    }

    //observer

    public void update(String nom, Transaction transaction) {
        System.out.println("========== Notification de " + this.nom + "========== " );
        System.out.println( nom + " a passer la  transaction suivante : "+ transaction );
        System.out.println("======================================================= " );
    }
}
