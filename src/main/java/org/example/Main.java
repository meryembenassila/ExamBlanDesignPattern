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
    }

}