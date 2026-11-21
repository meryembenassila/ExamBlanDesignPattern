package org.example;

public class AfficheurHdmi2 implements HDMI {

    @Override
    public void afficher(Conteneur conteneur) {
        System.out.println("==========Afficheur Hdmi 2 ====================");
        System.out.println("Conteneur contient les agents suivants");
        conteneur.getAgents().forEach((s, agent) -> {
            System.out.println(agent.getNom());
        });
        System.out.println("================================================");
    }
}
