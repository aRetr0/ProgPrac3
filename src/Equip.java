public class Equip {
    private String nomEquip;
    private int puntuacio = -1;
    public Equip (String nomEquip){
        this.nomEquip = nomEquip;
    }

    public void setPuntuacio(int novapuntuacio) {this.puntuacio = novapuntuacio;}

    public boolean getJugat() {return this.puntuacio != -1;}

    public String toString() {return ("Equip: " + this.nomEquip + " Puntuacio: " + this.puntuacio);}

    public String dades() {return (this.nomEquip + ";" + this.puntuacio);}

    public int compareTo(Equip e) {return Integer.compare(this.puntuacio, e.puntuacio);}
}
