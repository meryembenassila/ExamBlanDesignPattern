package org.example;

import java.util.List;



public class AfficheurVGA implements VGA{
    @Override

    public void print(List<Agent> agentList) {
        System.out.println("================AfficherVGA=================");

        System.out.println("Conteneur contient les agents suivants");
        agentList.forEach(( agent) -> {
            System.out.println(agent.getNom());
        });

        System.out.println("=============================================");
    }
}
