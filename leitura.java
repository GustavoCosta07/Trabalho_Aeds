import java.util.Scanner;
import java.io.*;
import java.time.LocalDate;

public class leitura {
    public static String[][] produtos = new String[4][5];

    public static void menu(Scanner ent) throws Exception {
        int opc;
        System.out.println("1-Fazer venda");

        System.out.println("2-Exibir estoque");

        System.out.println("3-Terminar dia e salvar relatório diário");
        opc = ent.nextInt();

        if (opc == 1) {
            venda(ent);
        } else if (opc == 2) {
            exibe();
        } else if (opc == 3) {
            fimDia();
        } else {
            System.out.println("Opção inválida");
        }
        if (opc != 3) {
            System.out.println();
            menu(ent);
        }
    }

    public static void preencherMatrizEstoque() {
        try {
            File file = new File("estoque.txt");
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

    public static void atualizacaoEstoque() throws IOException {

        File file = new File("estoque.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        String body = "";

        for (int i = 0; i < produtos.length; i++) {
            for (int j = 0; j < produtos[i].length; j++) {
                body += produtos[i][j] + ";";
            }
            body += "\n";
        }
        pw.print(body);
        pw.close();
    }

    public static void fimDia() throws IOException {
        relatorioEstoque();
        // relatorioVendas();
    }

    public static void venda(Scanner entrada) throws IOException {
        System.out.println("Qual o código do produto ?");
        exibe();
        int produtoEscolhido = entrada.nextInt();

        if (produtoEscolhido > produtos.length || produtoEscolhido < 0) {
            System.out.println("Codigo de produto inválido!");
            return;
        }

        int quantidadeSalva = Integer.parseInt(produtos[produtoEscolhido - 1][3]);

        System.out.println("Qual a quantidade ?");

        int quantidade = entrada.nextInt();

        if (quantidadeSalva <= 0) {
            System.out.println("Produto indisponível");
            return;
        }

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida!");
            return;
        }

        if (quantidade > quantidadeSalva) {
            System.out.println("Quantidade indisponível!");
            return;
        }

        System.out.println("Concluir venda? se sim digite 1, se não digite 2");
        int confirm = entrada.nextInt();

        if (confirm == 1) {
            produtos[produtoEscolhido - 1][3] = String.valueOf(quantidadeSalva - quantidade);
        }
        atualizacaoEstoque();

    }

    public static void relatorioEstoque() {
        try {
            FileWriter pw = new FileWriter("Relatório Estoque " + LocalDate.now().toString() + ".txt");

            String body = "|--------------------------------------------------|\n";

            String leftAlignFormat = "| %-10s | %-10s | %-10s | %-10s|%n";
            body += String.format(leftAlignFormat, "Codigo", "Tipo", "Categoria", "Estoque");

            body += "|--------------------------------------------------|\n";

            for (int i = 0; i < produtos.length; i++) {
                body += String.format(leftAlignFormat, produtos[i]);
            }

            body += "|--------------------------------------------------|\n";

            pw.write(body);

            pw.close();
            System.out.println("Relatório feito com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exibe() {
        String leftAlignFormat = "| %-10s | %-10s | %-10s | %-10s | %-10s |%n";
        System.out.format("|----------------------------------------------------------------|%n");
        System.out.format(leftAlignFormat, "Código", "Tipo", "Categoria", "Estoque", "Preço");
        System.out.format("|----------------------------------------------------------------|%n");
        for (int i = 0; i < produtos.length; i++) {
            System.out.format(leftAlignFormat, produtos[i]);
        }
        System.out.format("|----------------------------------------------------------------|%n");
    }

    public static void main(String[] args) throws Exception {

        preencherMatrizEstoque();
        Scanner ent = new Scanner(System.in);
        menu(ent);
        ent.close();
    }
}
