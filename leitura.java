import java.util.Scanner;
import java.io.*;

public class leitura {
    public static void exibe(String[][]x){
        System.out.println("  Tipo     Categoria  Estoque  Preço Código");
        for(int i=0;i<x.length;i++){                      
            for(int j=0;j<x[i].length;j++){
                
                System.out.print(x[i][j]+" | ");
                if(j==4){System.out.println();}
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
                  //  System.out.println(produtos[contador][j]);
                }
                contador++;
            }
            ler.close();
            exibe(produtos);
        } catch (Exception e) {
            System.out.println("erro -" + e.getMessage());
        }
    }
}
//teste