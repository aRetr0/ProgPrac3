public class Node{
    Equip inf;
    Node esq, dreta;
    Node() {this(null);}
    Node(Equip equip) {this(equip, null, null);}
    Node(Equip equip, Node node, Node node1) {
        this.inf = equip;
        this.esq = node;
        this.dreta = node1;
    }

    public Node compareTo(Node node){
        if (this.inf.getPuntuacio() > node.inf.getPuntuacio()) return this;
        return node;
    }
}
