import java.util.Scanner;

public class Loja {
    private static Estoque estoque;
    private static Controlador controlador;

    public static void menu() throws Exception {
        Scanner ent= new Scanner(System.in);
        int opc;
        System.out.println("1-Fazer venda");
        System.out.println("2-Exibir estoque");
        System.out.println("3-Terminar dia e salvar relatório diário");
        opc = ent.nextInt();
        if (opc == 1) {
            controlador.executarVenda();
        } else if (opc == 2) {
            controlador.exibirProdutos();
        } else if (opc == 3) {
            controlador.gerarRelatorio();
        } else {
            System.out.println("Opção inválida");
        }
        if (opc != 3) {
            System.out.println();
            menu();
        }
        ent.close();
    }

    public static void main(String[] args) throws Exception {
        estoque = new Estoque();
        Venda venda = new Venda();
        controlador = new Controlador(estoque, venda);
        menu();
    }
}
