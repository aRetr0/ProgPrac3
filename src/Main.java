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
                funcionaElJoc(1,new Arbre(equips, punts));
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            funcionaElJoc(1, new Arbre(equips,punts));
        }
    }
    private static void funcionaElJoc(int rondaActual,Arbre arbre) {
        if(arbre.getNombreRondes()==1){
            System.out.println("Ultima ronda! Així esta el taulell: ");
            arbre.mostrar(arbre.getArrel(), arbre.getProfunditat());
            System.out.println("---------------------------------------------");
            arbre.partit(arbre.getArrel());
            String[] temp = arbre.getEquips();
            int[] tempPunts = arbre.getPuntuacio();
            System.out.println("I aquest es el equip guanyador!!!! " + temp[0] + " amb aquesta puntuació: " + tempPunts[0]);
        }else {
            System.out.println("Ronda: " + rondaActual + ", així esta el taulell del torneig");
            arbre.mostrar(arbre.getArrel(), arbre.getProfunditat());
            System.out.println("---------------------------------------------");
            arbre.partit(arbre.getArrel());
            funcionaElJoc(rondaActual + 1, new Arbre(arbre.getEquips(), arbre.getPuntuacio()));
        }
    }
}