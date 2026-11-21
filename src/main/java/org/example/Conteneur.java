package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conteneur {

    private static final Conteneur conteneur;
    static {
        System.out.println("initialisation de singleton");
        conteneur = new Conteneur();
    }

    private Conteneur() {
    }
    public  static Conteneur getInsance(){
        return conteneur;
    }


    private Map<String, Agent> agents =new HashMap<>();

    public Map<String, Agent> getAgents() {
        return agents;
    }

    public synchronized void addAgent(Agent agent){

      agents.put(agent.getNom(),agent) ;

    }

    public synchronized void removeAgent(Agent agent){

        agents.remove(agent.getNom(),agent) ;

    }

    public void searchAgent(String nom){

        if(agents.get(nom)!=null){
            System.out.println(agents.get(nom));
        }else{
            System.out.println("l'agent recherché n'exsiste pas ");
        }
    }


    private HDMI hdmi;
    public void afficher(){
        hdmi.afficher(this);
    }

    public void setHdmi(HDMI hdmi) {
        this.hdmi = hdmi;
    }
}
