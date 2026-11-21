package org.example;

import java.util.ArrayList;
import java.util.List;

public class Adapter implements HDMI{
    private VGA vga = new AfficheurVGA();
    public void setVga(VGA vga) {
        this.vga = vga;
    }


    @Override
    public void afficher(Conteneur conteneur) {
        System.out.println("++++++++++ Adaptation ++++++++++++++");
        List<Agent> list = new ArrayList<>(conteneur.getAgents().values());
        vga.print(list);
        System.out.println("++++++++++ Adaptation ++++++++++++++");
    }
}
