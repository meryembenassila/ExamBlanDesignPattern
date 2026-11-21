package org.example;

import org.example.aspects.Log;
import org.springframework.stereotype.Service;

@Service
public class DefaultStrategy implements Strategy {

    @Override
    @Log
    public void traiterNotification(Transaction transaction) {
        System.out.println("********** DefaultStrategy ****************");
        System.out.println("Transaction a traité :"+transaction);
        System.out.println("*******************************************");
    }
}
