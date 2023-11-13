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
        } while (decisio != 1 && decisio != 2 && decisio != 9);
        if (decisio == 1) {
            try {
                String nomTorneig;
                File file = new File("test.txt");
                if (!file.exists()) {
                    System.out.println("El arxiu no existeix, assegura't de que esta a la mateixa carpeta que el java i que es diu test.txt");
                    System.out.println("Tancant programa...");
                    return;
                }
                nomTorneig = file.getName();
                BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
                String line;
                String[] equips = new String[0];
                String[] puntsTemp = new String[0];

                while ((line = reader.readLine()) != null) {
                    equips = line.split(";");
                    puntsTemp = line.split(";");
                }
                int[] punts = new int[equips.length];
                for (int i = 0; i < puntsTemp.length; i++) {
                    punts[i] = Integer.parseInt(puntsTemp[i]);
                }
                reader.close();
                Arbre arbre = new Arbre(equips, punts);
                arbre.funcionaElJoc();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (decisio == 9) {
            System.out.println("Creant equips automaticament...");
            int[] punts = {1, 2, 3, 4};
            String[] nomEquips = {"Eq 1", "Eq 2", "Eq 3", "Eq 4"};
            Arbre arbre = new Arbre(nomEquips, punts);
            arbre.funcionaElJoc(0);
        } else {
            int i = 0;
            do {
                System.out.print("Quants equips vols introduir? ");
                i = Keyboard.readInt();
            } while (i % 2 != 0 || i == 0);
            String[] equips = new String[i];
            int[] punts = new int[i];
            int cont = 0;
            while (cont < i) {
                System.out.print("Introdueix el nom del equip " + (cont + 1) + ": ");
                String nomEquip = Keyboard.readString();
                System.out.println("Introdueix la puntuacio del equip: " + (cont + 1));
                int puntuacio = Keyboard.readInt();
                punts[cont] = puntuacio;
                equips[cont] = nomEquip;
                cont++;
            }
            System.out.print("Equips guardats, introdueix el nom del torneig: ");
            String nomTorneig = Keyboard.readString();
            Arbre arbre = new Arbre(equips, punts);
            arbre.funcionaElJoc();
        }
    }
}