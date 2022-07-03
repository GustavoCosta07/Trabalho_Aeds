import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Estoque {
    private String[][] produtos = new String[4][5];
    private String caminhoArquivo = "estoque.txt";

    Estoque() {
        this.init();
    }

    private void init() {
        try {
            this.carregarProdutos();
        } catch (Exception e) {
            this.criarProdutos();
        }
    }

    private void carregarProdutos() throws FileNotFoundException {
        File file = new File(this.caminhoArquivo);
        Scanner ler = new Scanner(file);
        int contador = 0;
        while (ler.hasNextLine()) {
            String[] valores = ler.nextLine().split(";");
            for (int j = 0; j < valores.length; j++) {
                this.produtos[contador][j] = valores[j];
            }
            contador++;
        }
        ler.close();
    }

    private void criarProdutos() {
        try {
            File file = new File(this.caminhoArquivo);
            PrintWriter pw = new PrintWriter(file);
            pw.print(
                    "1;adulto;estampada;10;2.50;\n2;adulto;lisa;55;3.50;\n3;infantil;estampada;30;3.20;\n4;infantil;lisa;12;7.60;");
            pw.close();
            this.carregarProdutos();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void atualizarArquivo() throws IOException {
        File file = new File(this.caminhoArquivo);
        PrintWriter pw = new PrintWriter(file);
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

    public void validarCodigoProduto(int codigoProduto) throws Exception {
        if (codigoProduto > produtos.length || codigoProduto < 0) {
            throw new Exception("Codigo de produto inválido!");
        }
    }

    public void validarQuantidadeEstoque(int codigoProduto, int quantidade) throws Exception {
        if (codigoProduto > produtos.length || codigoProduto < 0) {
            throw new Exception("Codigo de produto inválido!");
        }

        int quantidadeSalva = Integer.parseInt(produtos[codigoProduto - 1][3]);

        if (quantidadeSalva <= 0) {
            throw new Exception("Produto indisponível");
        }

        if (quantidade <= 0) {
            throw new Exception("Quantidade inválida!");
        }

        if (quantidade > quantidadeSalva) {
            throw new Exception("Quantidade indisponível!");
        }
    }

    public void atualizarQuantidadeProduto(int codigoProduto, int quantidade) throws IOException {
        int quantidadeAtual = Integer.parseInt( produtos[codigoProduto - 1][3]);
        produtos[codigoProduto - 1][3] = String.valueOf(quantidadeAtual - quantidade);
        this.atualizarArquivo();
    }

    public String[] getProdutoPorCodigo(int codigo) throws Exception {
        if (codigo > produtos.length || codigo < 0) {
            throw new Exception("Codigo de produto inválido!");
        }

        return this.produtos[codigo - 1];
    }

    public void exibirProdutos() {
        String leftAlignFormat = "| %-10s | %-10s | %-10s | %-10s | %-10s |%n";
        System.out.format("|----------------------------------------------------------------|%n");
        System.out.format(leftAlignFormat, "Código", "Tipo", "Categoria", "Estoque", "Preço");
        System.out.format("|----------------------------------------------------------------|%n");
        for (int i = 0; i < produtos.length; i++) {
            System.out.format(leftAlignFormat, this.produtos[i]);
        }
        System.out.format("|----------------------------------------------------------------|%n");
    }

    public void gerarRelatorio() {
        try {
            FileWriter pw = new FileWriter("Relatório Estoque " + LocalDate.now().toString() + ".txt");
            String body = "|--------------------------------------------------|\n";
            String leftAlignFormat = "| %-10s | %-10s | %-10s | %-10s|%n";
            body += String.format(leftAlignFormat, "Codigo", "Tipo", "Categoria", "Estoque");
            body += "|--------------------------------------------------|\n";
            for (int i = 0; i < this.produtos.length; i++) {
                body += String.format(leftAlignFormat, this.produtos[i]);
            }
            body += "|--------------------------------------------------|\n";
            pw.write(body);
            pw.close();
            System.out.println("Relatório de estoque gerado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String [] obterProdutoPorCodigo(int codigoProduto) throws IOException {
        return produtos[codigoProduto - 1];
    }
}