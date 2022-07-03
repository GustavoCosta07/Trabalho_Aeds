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
        System.out.println("Qual o código do produto ?");
        estoque.exibirProdutos();
        int codigoProduto = entrada.nextInt();
        try {
            estoque.validarCodigoProduto(codigoProduto);
            System.out.println("Qual a quantidade ?");
            int quantidade = entrada.nextInt();
            estoque.validarQuantidadeEstoque(codigoProduto, quantidade);
            System.out.println("Concluir venda? se sim digite 1, se não digite 2");
            int confirm = entrada.nextInt();
            if (confirm == 1) {
                estoque.atualizarQuantidadeProduto(codigoProduto, quantidade);
                String produto [] = estoque.obterProdutoPorCodigo(codigoProduto);
                venda.salvarVenda(produto[1], produto[2], String.valueOf(quantidade), produto[4]);
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
