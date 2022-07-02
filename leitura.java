import java.util.Scanner;
import java.io.*;

public class leitura {
    public static int dias = 1;

    public static void menu(Scanner ent, String[][] produtos) throws Exception {
        int opc;
        System.out.println("1-Fazer venda");

        System.out.println("2-Exibir estoque");

        System.out.println("3-Terminar dia e salvar relatório diário");
        opc = ent.nextInt();

        if (opc == 1) {
            venda(ent, produtos);
        } else if (opc == 2) {
            exibe(produtos);
        } else if (opc == 3) {
            fimDia(produtos);
        } else {
            System.out.println("Opção inválida");
        }
        if (opc != 3) {
            System.out.println();
            menu(ent, produtos);
        }
    }

    public static void preencherMatrizEstoque(String[][] produtos) {
        try {
            File file = new File("estocagem.txt");
            Scanner ler = new Scanner(file);
            int contador = 0;
            while (ler.hasNextLine()) {

                String[] valores = ler.nextLine().split(";");

                for (int j = 0; j < valores.length; j++) {
                    produtos[contador][j] = valores[j];
                }
                contador++;
            }
            ler.close();

        } catch (Exception e) {
            System.out.println("erro -" + e.getMessage());
        }
    }

    public static void fimDia(String[][] produtos) {
        relatorioEstoque(produtos);
        // relatorioVendar();
        dias++;
    }

    public static void venda(Scanner entrada, String[][] matriz) {
        System.out.println("Qual o código do produto ?");
        exibe(matriz);
        int produtoEscolhido = entrada.nextInt();
        String produtoEscolhidoTratado = String.valueOf(produtoEscolhido);
        int contador = 0;
        
        System.out.println("Concluir venda? se sim digite 1, se não digite 2");
        int confirm = entrada.nextInt();


        if (confirm == 1) {
            for (int i = 0; i < matriz.length; i++) {
                if (matriz[contador][4].contains(produtoEscolhidoTratado)) {

                    String vetor = matriz[contador][2].replaceAll("\\s+", "");

                    System.out.println("Quantidade que deseja vender: ");
                    int quantidade = entrada.nextInt();
                    if (quantidade >= 1) {

                        int substitui = Integer.parseInt(vetor);
                        if (substitui > 0) {

                            substitui -= quantidade;

                            StringBuilder nome = new StringBuilder(substitui).append(substitui + "   ");
                            String nome2 = new String(nome);

                            matriz[contador][2] = nome2;
                            System.out.println("Venda feita com sucesso");
                           // exibe(matriz);
                            break;
                        } else {
                            System.out.println("produto fora de estoque");
                        }

                    } else {
                        System.out.println("quantidade inválida");
                    }

                }
                contador++;
            }
        } else if (confirm == 2) {
            System.out.println("operação cancelada");
        } else {
            System.out.println("dígito inválido");
        }

    }

    public static void relatorioEstoque(String[][] x) {
        try {
            FileWriter pw = new FileWriter("relatorioEstoque.txt", true);
            pw.write("\n" + "  Relatorio de estoque dia " + dias + "\n");
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
            System.out.println("Relatório feito com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public static void main(String[] args) throws Exception {
        Scanner ent = new Scanner(System.in);
        String[][] produtos = new String[4][5];
        preencherMatrizEstoque(produtos);
        menu(ent, produtos);
        ent.close();
    }
}
