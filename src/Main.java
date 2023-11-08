import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Arbre arbre = new Arbre();
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] equips = line.split(";");
                for (String equip : equips) {
                    arbre = new Arbre(new Equip(equip), null, null);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}