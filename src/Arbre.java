import Keyboard.Keyboard;

public class Arbre {
    private int profunditat, nombreEquips, nombreRondes;
    private int[] puntuacio;
    private String[] equips;
    Node arrel;
    public Arbre() {this.arrel = null;}
    public Arbre(String[] equips, int[] puntuacio) {
        this.equips = equips;
        this.puntuacio = puntuacio;
        this.nombreEquips = equips.length;
        this.nombreRondes = (int) (Math.log(this.nombreEquips+1) / Math.log(2));
        this.profunditat = this.nombreRondes + 1;
        this.arrel = new Node();
        for (int i = 0; i < equips.length && i < puntuacio.length; i++) {inserir(arrel, new Equip(equips[i], puntuacio[i]), this.profunditat);}
    }
    private boolean inserir(Node node, Equip equip, int profunditat) {
        if (profunditat == 1) {
           if (node.inf == null) {
               node.inf = equip;
               return true;
            } else {
               return false;
           }
       } else {
           if (node.esq == null) node.esq = new Node();
           if (node.dreta == null) node.dreta = new Node();
           return inserir(node.esq, equip, profunditat - 1) || inserir(node.dreta, equip, profunditat - 1);
       }
    }
    public void mostrar(Node node, int profunditat) {
        if (node == null) return;
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
        setEquips(nousEquips);
        setPuntuacio(punts);
    }
    private void setPuntuacio(int[] puntuacio) {this.puntuacio = puntuacio;}
    private void setEquips(String[] equips) {this.equips = equips;}
    public int[] getPuntuacio() {return puntuacio;}
    public String[] getEquips() {return equips;}
    public int getProfunditat() {return profunditat;}
    public int getNombreRondes() {return nombreRondes;}
    public Node getArrel() {return arrel;}
}
