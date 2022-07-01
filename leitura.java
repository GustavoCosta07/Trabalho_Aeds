import java.util.Scanner;
import java.io.*;

public class leitura {
    // public static void exibe(String[][][][] x) {
    //     for (int i = 0; i < x.length; i++) {

    //         for(int j=0;j<x[i].length;j++){

    //             for(int k=0;k<x[i][j].length;k++){

    //                 for(int l=0;l<x[i][j][k].length;l++){
    //                     System.out.println(x[i][j][k][l]);
    //                 }
    //                 System.out.println(x[i][j][k][0]);
    //             }
    //             System.out.println(x[i][j][0][0]);
    //         }
    //         System.out.println(x[i][0][0][0]);
    //     }
    //     System.out.println();
    //     System.out.println();
    // }

    public static String[] salva(String[] x) {
        return x;
    }

    public static void main(String[] args) {
        Scanner ent = new Scanner(System.in);
        try {
            File file = new File("estocagem.txt");
            Scanner ler = new Scanner(file);
     
            String[][][][] produtos = new String[3][3][3][3];

            String salva = "";
            int pos = 0;

            while (ler.hasNextLine()) {
                salva += ler.nextLine();

                String[] valores = salva.split(";");
                pos = valores.length;
               
                if (pos == 3) {
                    int j = 0;
                    for (int i = 0; i < valores.length; i++) {
                        String val = valores[i];
                        produtos[j][0][0][0] = val;
                        System.out.println(produtos[j][0][0][0]);
                        j++;
                    }
                }
                if (pos == 6) {
                    int j = 0;
                    for (int i = 3; i < valores.length; i++) {
                        String val = valores[i];
                        produtos[0][j][0][0] = val;
                        System.out.println(produtos[0][j][0][0]);
                        j++;
                    }                 
                }
                if (pos == 9) {
                    int j = 0;
                    for (int i = 6; i < valores.length; i++) {
                        String val = valores[i];
                        produtos[0][0][j][0] = val;
                        System.out.println(produtos[0][0][j][0]);
                        j++;
                    }                    
                }
                if (pos == 12) {
                    int j = 0;
                    for (int i = 9; i < valores.length; i++) {
                        String val = valores[i];
                        produtos[0][0][0][j] = val;
                        System.out.println(produtos[0][0][0][j]);
                        j++;
                    }                  
                }
            }
           // exibe(produtos);
            ler.close();

        } catch (Exception e) {
            System.out.println("erro");
        }

        ent.close();
    }
}
//teste