import Keyboard.Keyboard;

import java.util.Random;

public class Arbre {
    private int profunditat, nombreEquips, nombreRondes;
    private int[] puntuacio;
    private String[] equips;
    private static Node tempDreta, tempEsquerre, nodePare;
    Node arrel;
    public Arbre() {this.arrel = null;}
    public Arbre(String[] equips, int[] puntuacio) {
        this.equips = equips;
        this.puntuacio = puntuacio;
        this.nombreEquips = equips.length;
        double temp = Math.log(this.nombreEquips+1) / Math.log(2);
        this.nombreRondes = (int) temp;
        this.profunditat = this.nombreRondes + 1;
        this.arrel = new Node();
        for (int i = 0; i < equips.length && i < puntuacio.length; i++) {
            inserir(arrel, new Equip(equips[i], puntuacio[i]), this.profunditat);
        }
    }
    public boolean inserir(Node node, Equip equip, int profunditat) {
        if (profunditat == 0) {
            if (node.inf == null) {
                node.inf = equip;
                return true;
            } else return false;
        } else {
            if (node.esq == null) node.esq = new Node();
            if (node.dreta == null) node.dreta = new Node();
            return inserir(node.esq, equip, profunditat - 1) || inserir(node.dreta, equip, profunditat - 1);
        }
    }
    public void mostrar(Node node, int profunditat) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < profunditat; i++) {
            System.out.print("\t");
        }
        if (node.inf != null) {
            System.out.print("");
            System.out.println(node.inf);

        } else {
            System.out.print("");
            System.out.println("Partit no jugat");
        }
        mostrar(node.esq, profunditat + 1);
        mostrar(node.dreta, profunditat + 1);
    }

    public void funcionaElJoc(int rondaActual) {
        System.out.println("Ronda: " + rondaActual + ", així esta el taulell del torneig");
        this.mostrar(this.arrel, this.profunditat);
        System.out.println("---------------------------------------------");
        partit(this.arrel);
        funcionaElJoc(rondaActual + 1);
        if (rondaActual < this.nombreRondes) {

        } else {
            System.out.println(this.nombreRondes);
            funcionaElJoc();
        }
    }
    public void partit(Node node){
        String[] nousEquips = new String[equips.length/2];
        int[] punts = new int[puntuacio.length/2];
        int posicioTemporal=0;
        for (int i=0; i<equips.length; i +=2){
            if (equips[i]!=null || equips[i+1]!=null){
                if (puntuacio[i]>puntuacio[i+1]){
                    nousEquips[posicioTemporal] = equips[i];
                    System.out.println("Ha guanyat el equip: " + equips[i]  + ", introdueix la puntuació per el nou partit: ");
                    punts[posicioTemporal] = Keyboard.readInt();
                    posicioTemporal++;
                } else {
                    nousEquips[posicioTemporal] = equips[i+1];
                    System.out.println("Ha guanyat el equip: "+ equips[i+1]  + ", introdueix la puntuació per el nou partit: ");
                    punts[posicioTemporal] = Keyboard.readInt();
                    posicioTemporal++;
                }
            }
        }
        new Arbre(nousEquips,punts);
    }

    public void trobarOmplirPare(Node nodeActual) {
        if (nodeActual.esq != null && nodeActual.dreta != null) {
            nodeActual = tempDreta.compareTo(tempEsquerre);
        } else if (nodeActual.esq != null) {
            trobarOmplirPare(nodeActual.dreta);
        } else if (nodeActual.dreta != null) {
            trobarOmplirPare(nodeActual.esq);
        } else{
            trobarOmplirPare(nodeActual);
        }
    }

    public void funcionaElJoc() {
        System.out.println("Última ronda: ");
        this.mostrar(this.arrel, this.profunditat);
        System.out.println("Equip guanyador: " + this.arrel.inf.getNomEquip() + " amb " + this.arrel.inf.getPuntuacio() + " punts.");
    }
    public Node recursivitatEsquerre(Node node) {
        if (node.inf == null) {
            nodePare = node;
            return recursivitatEsquerre(node.esq);
        } else {
            return node;
        }
    }

    public Node recursivitatDreta(Node node) {
        if (node.inf == null) {
            nodePare = node;
            return recursivitatDreta(node.dreta);
        } else {
            return node;
        }
    }

    public int getProfunditat() {
        return profunditat;
    }

    public int getNombreEquips() {
        return nombreEquips;
    }

    public int getNombreRondes() {
        return nombreRondes;
    }

    public Node getArrel() {
        return arrel;
    }
}
