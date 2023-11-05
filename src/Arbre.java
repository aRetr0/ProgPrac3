public class Arbre implements InterfaceArbre{
    private int profunditat;
    private int nombreEquips;
    Node arrel;
    public Arbre(){
        this.arrel=null;
    }
    public Arbre(Equip equip,Arbre a_esq,Arbre a_dreta){
        arrel = new Node (equip,a_esq.arrel,a_dreta.arrel);
    }
    public Equip arrel() throws Exception {
        if (arrel == null) throw new Exception("L'arbre es buit");
        else return arrel.inf;
    }
    public void buidar() {
        arrel = null;
    }
    public InterfaceArbre fillEsquerra() throws Exception {
        if (!esBuit()){
            InterfaceArbre temp = new Arbre();
            ((Arbre)temp).arrel = arrel.esq;
            return temp;
        } else throw new Exception("L'arbre es buit");
    }
    public InterfaceArbre fillDret() throws Exception {
        if (!esBuit()){
            InterfaceArbre temp = new Arbre();
            ((Arbre)temp).arrel = arrel.dreta;
            return temp;
        } else throw new Exception("L'arbre es buit");
    }
    public boolean esBuit() {
        return this.arrel == null;
    }


}
