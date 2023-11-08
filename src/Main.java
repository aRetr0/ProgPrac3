import Keyboard.Keyboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Vols crear el torneig amb un arxiu .txt o manualment?");
        int decisio = 0;
        do {
            System.out.println("Si vols crear amb arxiu text puja el arxiu a la mateixa carpeta que el java i introdueix el nombre 1, per contrabanda introdueix el nombre 2: ");
            decisio = Keyboard.readInt();
        } while(decisio != 1 && decisio != 2);
        if (decisio==1){
            try {
                String nomTorneig;
                File file = new File("test.txt");
                nomTorneig = file.getName();
                BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
                String line;
                String[] equips = new String[0];
                while ((line = reader.readLine()) != null) {
                    equips = line.split(";");
                }
                Arbre arbre = new Arbre(equips);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            int i = 0;
            do{
                System.out.print("Quants equips vols introduir? ");
                i = Keyboard.readInt();
            } while(i % 2 != 0 || i == 0);
            String[] equips = new String[i];
            int cont = 0;
            while (cont<i){
                System.out.print("Introdueix el nom del equip " + (cont + 1) + ": ");
                String nomEquip = Keyboard.readString();
                equips[cont] = nomEquip;
                cont++;
            }
            System.out.print("Equips guardats, introdueix el nom del torneig: ");
            String nomTorneig = Keyboard.readString();
            Arbre arbre = new Arbre(equips);
            arbre.mostrar(0);
        }


    }
}