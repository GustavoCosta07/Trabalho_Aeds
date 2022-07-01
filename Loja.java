import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Loja {

    public static void menu() {
        System.out.println();
        System.out.println("4 - Gerar relatório de máscaras em estoque");
        System.out.println();
        try {
            Scanner entrada = new Scanner(System.in);
            int codigoMenu = entrada.nextInt();
            entrada.close();
            if (codigoMenu == 4) {
                gerarRelatorioMascarasEmEstoque();
            }
        } catch (Exception e) {
            menu();
        }
    }

    public static void gerarRelatorioMascarasEmEstoque() {
        try {
            File file = new File("produtos.csv"); // creates a new file instance
            FileReader fr = new FileReader(file); // reads the file
            BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
            StringBuffer sb = new StringBuffer(); // constructs a string buffer with no characters
            String line;
            sb.append("-----------------------------------------------------\n");
            sb.append("codigo | categoria | tipo | quantidade | preco\n");
            while ((line = br.readLine()) != null) {
                String[] dados = line.split(",");
                sb.append(dados[0] + " | " +  dados[1] + " | " + dados[2] + " | " + dados[3] + " | " + dados[4] + " | " + "\n" );
            }
            sb.append("-----------------------------------------------------");
            fr.close(); // closes the stream and release the resources
            System.out.println("Contents of File: ");
            System.out.println(sb.toString());
    
        } catch (Exception e) {
            // TODO: handle exception
        }
       
        // System.out.println(Arquivo.lerArquivo("produtos.csv"));
    }

    public static void main(String[] args) throws IOException {

        menu();

        // LocalDate myObj = LocalDate.now(); // Create a date object
        // System.out.println(myObj); // Display the current date

        // Scanner entrada = new Scanner(System.in);

        // String MascaraAdultoLisa = "MascaraAdultoLisa";

        // System.out.println("Olá produtor, Quais são os produtos que você tem em
        // estoque ?" +
        // " Vamos montar o inventário para você.");
        // System.out.println("Produtos: ");
        // System.out.println("1 - Máscara adulta lisa");
        // System.out.println("2 - Máscara adulta estampada");
        // System.out.println("3 - Máscara infantil lisa");
        // System.out.println("4 - Máscara infantil estampada");
        // System.out.println("Você possui o produto 1? Se sim digite 1, Se não digite
        // 2");
        // int Produto = entrada.nextInt();
        // if (Produto == 1) {
        // System.out.println("Qual a quantidade? ");
        // int quantidadeMascaraAdultoLisa = entrada.nextInt();
        // // criarArquivo(MascaraAdultoLisa);
        // } else {

        // }
        // System.out.println("Você possui o produto 2? Se sim digite 1, Se não digite
        // 2");
        // int Produto2 = entrada.nextInt();
        // if (Produto2 == 1) {
        // System.out.println("Qual a quantidade? ");
        // int quantidadeMascaraAdultoEstampada = entrada.nextInt();
        // }
        // System.out.println("Você possui o produto 3? Se sim digite 1, Se não digite
        // 2");
        // int Produto3 = entrada.nextInt();
        // if (Produto3 == 1) {
        // System.out.println("Qual a quantidade? ");
        // int quantidadeMascaraInfantilLisa = entrada.nextInt();
        // }
        // System.out.println("Você possui o produto 4? Se sim digite 1, Se não digite
        // 2");
        // int Produto4 = entrada.nextInt();
        // if (Produto4 == 1) {
        // System.out.println("Qual a quantidade? ");
        // int quantidadeMascaraInfantilEstampada = entrada.nextInt();
        // }

        // entrada.close();
    }

    public static void criarArquivo(String produto) throws IOException {
        File file = new File("estoque.txt");
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(produto);

        pw.close();
    }
}
// ler do arquivo e mandar para a matriz