package testeDesenvolvedor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Empacotamento {

  public static void gravarArquivoBinario(Dados dados) {
    try {
    	 String fileName = "saida.dat";
    	 String filePath = System.getProperty("user.home")  + "\\data\\out\\";
    	 System.out.println("Gravando arquivo: "+filePath+fileName);
    	 System.out.println("------------------------------------------------------");
    	 File arq = new File(filePath+fileName);
    	 arq.delete();
    	 arq.createNewFile();
    	 ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
    	 objOutput.writeObject(dados);
    	 objOutput.close();

    } catch(IOException erro) {
        System.out.printf("Erro: %s", erro.getMessage());
    }
  }

  public static Dados lerArquivoBinario() {
    Dados dados = new Dados(null, null, null);
    try {
    	String fileName = "entrada.dat";
    	String filePath = System.getProperty("user.home")  + "\\data\\in\\";
//    	String filePath = System.getProperty("user.home")  + "\\data\\out\\";
    	System.out.println("Lendo arquivo: "+filePath+fileName);
    	System.out.println("------------------------------------------------------");
    	File arq = new File(filePath+fileName);
      if (arq.exists()) {
         ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
         dados = (Dados)objInput.readObject();
         objInput.close();
      }
    } catch(IOException erro1) {
        System.out.printf("Erro: %s", erro1.getMessage());
    } catch(ClassNotFoundException erro2) {
        System.out.printf("Erro: %s", erro2.getMessage());
    }

    return(dados);
  }
}