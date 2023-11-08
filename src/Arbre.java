public class Arbre {
    private int profunditat;
    private int nombreEquips;
    private int nombreRondes;
    Node arrel;

    public Arbre() {this.arrel = null;}

    public Arbre(String[] equips){
        this.nombreEquips = equips.length;
        this.nombreRondes = (int) ((int)Math.log(this.nombreEquips)/Math.log(2));
        this.profunditat = this.nombreRondes + 1;
        this.arrel = new Node();
        for (String equip : equips) {
            inserir(arrel, new Equip(equip), this.profunditat);
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
            System.out.print("         ");
            System.out.println(node.inf);

        } else {
            System.out.print("                                    ");
            System.out.println("Partit no jugat");
        }
        mostrar(node.esq, profunditat + 1);
        mostrar(node.dreta, profunditat + 1);
    }

    public int getProfunditat() {return profunditat;}

    public int getNombreEquips() {return nombreEquips;}

    public int getNombreRondes() {return nombreRondes;}
}
