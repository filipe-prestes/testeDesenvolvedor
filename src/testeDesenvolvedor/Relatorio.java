package testeDesenvolvedor;

import java.io.Serializable;


public class Relatorio implements Serializable {
	private static final long serialVersionUID = -625885360819514500L;
	private int qtdClientes;
	private String idMaiorVenda;
	private int qtdVendedor;
	private String idPiorVendedor;
	private String piorVendedor;

	public Relatorio(int qtdClientes, String idMaiorVenda, int qtdVendedorArquivo, String idPiorVendedor, String piorVendedor) {
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

	public String getIdMaiorVenda() {
		return idMaiorVenda;
	}

	public void setIdMaiorVenda(String idMaiorVenda) {
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

	public String getIdPiorVendedor() {
		return idPiorVendedor;
	}

	public void setIdPiorVendedor(String idPiorVendedor) {
		this.idPiorVendedor = idPiorVendedor;
	}

}
