import java.util.Scanner;
import java.io.*;

public class leitura {
    public static int dias = 1;
    // public static void fimDia(){

    // dias++;
    // }
    public static void relatorioEstoque(String[][] x) throws Exception {
        FileWriter pw = new FileWriter("relatorioEstoque.txt", true);
        pw.write("\n"+"  Relatorio de estoque dia "+dias+"\n");
        pw.write(" Tipo      Categoria  Estoque  " + "\n");
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length - 2; j++) {

                pw.write(x[i][j] + " | ");
                if (j == 2) {
                    pw.write("\n");
                }
            }
        }

        pw.close();
    }

    public static void exibe(String[][] x) {
        System.out.println("  Tipo     Categoria  Estoque  ");
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length - 2; j++) {

                System.out.print(x[i][j] + " | ");
                if (j == 2) {
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("estocagem.txt");
            Scanner ler = new Scanner(file);

            String[][] produtos = new String[4][5];

            int contador = 0;

            while (ler.hasNextLine()) {

                String[] valores = ler.nextLine().split(";");

                for (int j = 0; j < valores.length; j++) {
                    produtos[contador][j] = valores[j];
                    // System.out.println(produtos[contador][j]);
                }
                contador++;
            }
            ler.close();
            exibe(produtos);
            relatorioEstoque(produtos);
        } catch (Exception e) {
            System.out.println("erro -" + e.getMessage());
        }
    }
}
//resolução