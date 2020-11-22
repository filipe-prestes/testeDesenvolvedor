package testeDesenvolvedor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Empacotamento {

  public static void gravarArquivoDadosBinario(Dados dados, String fileName) {
    try {    	 
    	 String filePath = System.getProperty("user.home")  + "\\data\\in\\";
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
  
  public static void gravarArquivoRelatorioBinario(Relatorio relatorio, String fileName) {
	    try {    	 
	    	 String filePath = System.getProperty("user.home")  + "\\data\\out\\";
	    	 System.out.println("Gravando relatório: "+filePath+fileName);
	    	 System.out.println("------------------------------------------------------");
	    	 File arq = new File(filePath+fileName);
	    	 arq.delete();
	    	 arq.createNewFile();

	    	 ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
	    	 objOutput.writeObject(relatorio);
	    	 objOutput.close(); 	
	    } catch(IOException erro) {
	        System.out.printf("Erro: %s", erro.getMessage());
	    }
	  }

  public static ArrayList<Arquivo> lerArquivosDadosBinarios() {
	  ArrayList<Arquivo> arquivoList = new ArrayList<Arquivo>();
    try {
    	String filePath = System.getProperty("user.home")  + "\\data\\in\\";
    	System.out.println("Lendo diretório: "+filePath);
    	System.out.println("------------------------------------------------------");
    	File file = new File(filePath);
		File afile[] = file.listFiles();
		if(afile.length != 0) {
			int i = 0;
			for (int j = afile.length; i < j; i++) {
				File arq = afile[i];			
				if (arq.exists()) {
					System.out.println("Lendo Arquivo: "+arq.getName());
					ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));				
					try {
						Dados dados = (Dados)objInput.readObject();						
						arquivoList.add(new Arquivo(arq.getName(), dados, null));
						objInput.close();
					} catch (Exception e) {
						System.err.println("Arquivo inconpativel.");
					}
				}
			}			
		}else {
			System.err.println("Nenhum arquivo encontrado.");
		}
		System.out.println("------------------------------------------------------");
		return arquivoList;
    } catch(IOException erro1) {
        System.out.printf("Erro: %s", erro1.getMessage());
        
    } 
    return arquivoList;
  }
  
  public static ArrayList<Arquivo> lerArquivosRelatoriosBinarios() {
	  ArrayList<Arquivo> arquivoList = new ArrayList<Arquivo>();
    try {
    	String filePath = System.getProperty("user.home")  + "\\data\\out\\";
    	
    	System.out.println("Lendo diretório: "+filePath);
    	System.out.println("------------------------------------------------------");
    	File file = new File(filePath);
		File afile[] = file.listFiles();
		if(afile.length != 0) {
			int i = 0;
			for (int j = afile.length; i < j; i++) {
				File arq = afile[i];			
				if (arq.exists()) {
					System.out.println("Lendo Relatório: "+arq.getName());
					ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));				
					try {
						Relatorio relatorio = (Relatorio)objInput.readObject();						
						arquivoList.add(new Arquivo(arq.getName(), null, relatorio));
						objInput.close();
					} catch (Exception e) {
						System.err.println("Relatório inconpatÃ­vel.");
						System.out.println("PadrÃ£o esperado: testeDesenvolvedor\\Relatorio.java");
					}
				}
			}			
		}else {
			System.err.println("Nenhum relatório encontrado.");
		}
		System.out.println("------------------------------------------------------");
		return arquivoList;
    } catch(IOException erro1) {
        System.out.printf("Erro: %s", erro1.getMessage());
        
    } 
    return arquivoList;
  }
  
  public static void visualizarArquivos(String diretorio) throws IOException {
		File file = new File(diretorio);
		File afile[] = file.listFiles();
		int i = 0;
		for (int j = afile.length; i < j; i++) {
			File arquivos = afile[i];
			System.out.println(arquivos.getName());
		}

	}
}