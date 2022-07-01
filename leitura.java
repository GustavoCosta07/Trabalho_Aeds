import java.util.Scanner;
import java.io.*;

public class leitura {
    public static void main(String[] args) {
        try {
            File file = new File("estocagem.txt");
            Scanner ler = new Scanner(file);

            String[][] produtos = new String[4][4];

            int contador = 0;

            while (ler.hasNextLine()) {

                String[] valores = ler.nextLine().split(";");

                for (int j = 0; j < valores.length; j++) {
                    produtos[contador][j] = valores[j];
                    System.out.println(produtos[contador][j]);
                }
                contador++;
            }
            ler.close();

        } catch (Exception e) {
            System.out.println("erro -" + e.getMessage());
        }
    }
}
//teste