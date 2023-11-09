import java.io.FileWriter;
import java.io.IOException;

public class Equip {
    private String nomEquip;
    private int puntuacio = -1;

    public Equip(String nomEquip) {this.nomEquip = nomEquip;}

    public Equip(String nomEquip, int puntuacio) {
        this.nomEquip = nomEquip;
        this.puntuacio = puntuacio;
    }

    public void setPuntuacio(int novapuntuacio) {this.puntuacio = novapuntuacio;}

    public boolean haJugat() {return this.puntuacio != -1;}

    public String toString() {return ("Equip: " + this.nomEquip + " Puntuacio: " + this.puntuacio);}

    public String toSave() {
        return (this.nomEquip + "; " + this.puntuacio);
    }

    public String dades() {return (this.nomEquip + ";" + this.puntuacio);}

    public int compareTo(Equip e) {return Integer.compare(this.puntuacio, e.puntuacio);}
}
