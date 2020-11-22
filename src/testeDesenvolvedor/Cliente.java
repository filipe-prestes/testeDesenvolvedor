package testeDesenvolvedor;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cliente implements Serializable {
	private static final long serialVersionUID = -1722910211005930455L;
	private int id;
	private String nome;
	private String cnpj;
	private BigDecimal salario;
	private String area;

	public Cliente(String nome, String cnpj, BigDecimal salario, String area) {
		this.id = 002;
		this.nome = nome;
		this.cnpj = cnpj;
		this.salario = salario;
		this.area = area;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
