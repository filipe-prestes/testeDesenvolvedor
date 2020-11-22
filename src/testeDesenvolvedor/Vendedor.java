package testeDesenvolvedor;
import java.io.Serializable;
import java.math.BigDecimal;

public class Vendedor implements Serializable {
	private static final long serialVersionUID = -4928794813916739591L;
	private int id;
	private String nome;
	private String cpf;
	private BigDecimal salario;

	public Vendedor(String nome, String cpf, BigDecimal salario2) {
		this.id = 001;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
}
