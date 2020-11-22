package testeDesenvolvedor;

import java.io.Serializable;
import java.util.ArrayList;

public class Vendas implements Serializable {
	private static final long serialVersionUID = -4928794813916739591L;
	private int id;
	private int idVenda;
	private ArrayList<ItemVenda> itemVenda;
	private int idVendedor;
	private String nomeVendedor;

	public Vendas(int idVenda, ArrayList<ItemVenda> itemVenda,int idVendedor, String nomeVendedor) {
		this.id = 003;
		this.idVenda = idVenda;
		this.idVendedor = idVendedor;
		this.itemVenda = itemVenda;
		
		this.nomeVendedor = nomeVendedor;
		
	}

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public ArrayList<ItemVenda> getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(ArrayList<ItemVenda> itemVenda) {
		this.itemVenda = itemVenda;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public int getId() {
		return id;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}
}
