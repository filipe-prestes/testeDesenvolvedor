package testeDesenvolvedor;

public class Arquivo {
	
	private String nome;
	private Dados dados;
	private Relatorio relatorio;
	
	public Arquivo(String nome, Dados dados, Relatorio relatorio) {
		this.nome = nome;
		this.dados = dados;
		this.relatorio = relatorio;
	}
	
	public Dados getDados() {
		return dados;
	}
	public void setDados(Dados dados) {
		this.dados = dados;
	}

	public Relatorio getRelatorio() {
		return relatorio;
	}

	public void setRelatorio(Relatorio relatorio) {
		this.relatorio = relatorio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
