import java.util.Scanner;

public class Controlador {

    private Estoque estoque;
    private Venda venda;
    private Scanner entrada = new Scanner(System.in);

    Controlador(Estoque estoque, Venda venda) {
        this.estoque = estoque;
        this.venda = venda;
    }

    public void executarVenda () {
        System.out.println("Digite o código do produto: ");
        estoque.exibirProdutos();
        int codigoProduto = entrada.nextInt();
        try {
            estoque.validarCodigoProduto(codigoProduto);
            System.out.print("Digite a quantidade: ");
            int quantidade = entrada.nextInt();
            System.out.println();
            estoque.validarQuantidadeEstoque(codigoProduto, quantidade);
            System.out.println("Digite 1 para concluir venda ou digite 2 para cancelar");
            int confirm = entrada.nextInt();
            if (confirm == 1) {
                estoque.atualizarQuantidadeProduto(codigoProduto, quantidade);
                String produto [] = estoque.obterProdutoPorCodigo(codigoProduto);
                venda.salvarVenda(produto[1], produto[2], String.valueOf(quantidade), produto[4]);
                System.out.println("Venda feita com sucesso.");
            }
        } catch (Exception error) {
            System.err.println(error.getMessage());
        }
    }

    public void exibirProdutos() {
        this.estoque.exibirProdutos();
    }

    public void gerarRelatorio() {
        this.estoque.gerarRelatorio();
        this.venda.gerarRelatorio();
    }
}
