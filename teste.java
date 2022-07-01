import java.util.Scanner;
import java.io.*;


public class teste{
    public static void exibe(String[]x){
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
    }
    
    public static String[] salva(String[]x){
        return x;
    }
   public static void main(String[] args){
    Scanner ent = new Scanner (System.in);
    try {
        File file = new File("C://arquivos/estocagem.txt");
        Scanner ler = new Scanner(file);
        String[]mascaraAdultaEstampada=new String[3];
        String[]mascaraAdultaLisa = new String[3];
        
        String salva="";

        while(ler.hasNextLine()){
             salva+= ler.nextLine();
            
            String[] valores =salva.split(";");
           

            if(valores.length==3){
            mascaraAdultaEstampada= salva(valores);
            System.out.println(mascaraAdultaEstampada.length);
            exibe(mascaraAdultaEstampada);
            }if(valores.length==6){
            mascaraAdultaLisa = salva(valores);
            exibe(mascaraAdultaLisa);
            }
        }
        
        
        ler.close();
        
       
    } catch (Exception e) {
        System.out.println("erro");
    }


    ent.close();
   }
}