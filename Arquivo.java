import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Arquivo {
    public static String lerArquivo(String nomeArquvo) {
        Path caminho = Paths.get(nomeArquvo);
        try {
            byte[] texto = Files.readAllBytes(caminho);
            String leitura = new String(texto);
            return leitura;
        } catch (Exception erro) {
            return null;
        }
    }

    public static void criarArquivo(String nomeArquivo, String dados) throws IOException {
        File file = new File(nomeArquivo);
        FileWriter fw = new FileWriter(file, true);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(dados);
        pw.close();
    }
}
// teste
