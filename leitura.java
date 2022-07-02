import java.util.Scanner;
import java.io.*;

public class leitura {
    public static void exibe(String[][] x) {
        System.out.println("  Tipo     Categoria  Estoque  Preço Código");
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {

                System.out.print(x[i][j] + " | ");
                if (j == 4) {
                    System.out.println();
                }
            }
        }
    }

    public static void venda(String[][] matriz) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Qual produto deseja vender ?");
        int produtoEscolhido = entrada.nextInt();
        String produtoEscolhidoTratado = String.valueOf(produtoEscolhido);
        int contador = 0;
        System.out.println("Concluir venda? se sim digite 1, se não digite 2");
        int confirm = entrada.nextInt();
        if (confirm == 1) {
            for (int i = 0; i < matriz.length; i++) {
                if (matriz[contador][4].contains(produtoEscolhidoTratado)) {
                    
                    String vetor = matriz[contador][2].replaceAll("\\s+", "");

                    int substitui = Integer.parseInt(vetor);
                    substitui --;
                    StringBuilder nome = new StringBuilder(substitui).append( substitui + "   ");
                    String nome2 = new String(nome);

                    matriz[contador][2] = nome2;
                    
                    exibe(matriz);
                }
                contador++;
            }
        } else if (confirm == 2) {
            System.out.println("operação cancelada");
        } else {
            System.out.println("dígito inválido");
        }


        entrada.close();
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
                   
                }
                contador++;
            }
            ler.close();
            exibe(produtos);
            venda(produtos);
        } catch (Exception e) {
            System.out.println("erro -" + e.getMessage());
        }
    }
}
// teste