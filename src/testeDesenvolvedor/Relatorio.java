package testeDesenvolvedor;

import java.io.Serializable;


public class Relatorio implements Serializable {
	private static final long serialVersionUID = -625885360819514500L;
	private int qtdClientes;
	private int idMaiorVenda;
	private int qtdVendedor;
	private int idPiorVendedor;
	private String piorVendedor;

	public Relatorio(int qtdClientes, int idMaiorVenda, int qtdVendedorArquivo, int idPiorVendedor, String piorVendedor) {
		this.qtdClientes = qtdClientes;
		this.idMaiorVenda = idMaiorVenda;
		this.qtdVendedor = qtdVendedorArquivo;
		this.idPiorVendedor = idPiorVendedor;
		this.piorVendedor = piorVendedor;		
	}

	public int getQtdClientes() {
		return qtdClientes;
	}

	public void setQtdClientes(int qtdClientes) {
		this.qtdClientes = qtdClientes;
	}

	public int getIdMaiorVenda() {
		return idMaiorVenda;
	}

	public void setIdMaiorVenda(int idMaiorVenda) {
		this.idMaiorVenda = idMaiorVenda;
	}

	public int getQtdVendedor() {
		return qtdVendedor;
	}

	public void setQtdVendedor(int qtdVendedor) {
		this.qtdVendedor = qtdVendedor;
	}

	public String getPiorVendedor() {
		return piorVendedor;
	}

	public void setPiorVendedor(String piorVendedor) {
		this.piorVendedor = piorVendedor;
	}

	public int getIdPiorVendedor() {
		return idPiorVendedor;
	}

	public void setIdPiorVendedor(int idPiorVendedor) {
		this.idPiorVendedor = idPiorVendedor;
	}

}
