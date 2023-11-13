import Keyboard.Keyboard;

public class Arbre {
    private int profunditat;
    private int nombreEquips;
    private int nombreRondes;
    Node arrel;
    private static Node tempDreta;
    private static Node tempEsquerre;
    public Arbre() {this.arrel = null;}

    public Arbre(String[] equips, int[] puntuacio) {
        this.nombreEquips = equips.length;
        this.nombreRondes = (int) ((int) Math.log(this.nombreEquips) / Math.log(2));
        this.profunditat = this.nombreRondes + 1;
        this.arrel = new Node();
        for (int i = 0; i < equips.length && i < puntuacio.length; i++) {
            inserir(arrel, new Equip(equips[i], puntuacio[i]), this.profunditat);
        }
    }
    private boolean inserir(Node node, Equip equip, int profunditat) {
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

    public void buidar() {this.arrel = null;}

    public boolean esBuit() {return this.arrel == null;}

    public void mostrar(int profunditat) {
        mostrar(this.arrel, profunditat);
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
    public void funcionaElJoc(){
        for (int i=1; i<=this.nombreRondes; i++){
            System.out.println("Ronda: " + i + ", així esta el taulell del torneig");
            this.mostrar(this.arrel, this.profunditat);
            System.out.println("------------------------------");
            tempEsquerre = recursivitatEsquerre(this.arrel);
            tempDreta = recursivitatDreta(this.arrel);
        }
    }
    private Node recursivitatEsquerre(Node node){
        if (node.inf == null) recursivitatEsquerre(node.esq);
        else return node;
        return null; // no arriba mai
    }
    private Node recursivitatDreta(Node node){
        if (node.inf == null) recursivitatDreta(node.dreta);
        else return node;
        return null; // no arriba mai
    }

    public int getProfunditat() {return profunditat;}
    public int getNombreEquips() {return nombreEquips;}
    public int getNombreRondes() {return nombreRondes;}
}
