package testeDesenvolvedor;

import java.io.Serializable;
import java.util.ArrayList;

public class Vendas implements Serializable {
	private static final long serialVersionUID = -4928794813916739591L;
	private String id;
	private String idVenda;
	private ArrayList<ItemVenda> itemVenda;
	private String idVendedor;
	private String nomeVendedor;

	public Vendas(String idVenda, ArrayList<ItemVenda> itemVenda,String idVendedor, String nomeVendedor) {
		this.id = "003";
		this.idVenda = idVenda;
		this.idVendedor = idVendedor;
		this.itemVenda = itemVenda;		
		this.nomeVendedor = nomeVendedor;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}

	public ArrayList<ItemVenda> getItemVenda() {
		return itemVenda;
	}

	public void setItemVenda(ArrayList<ItemVenda> itemVenda) {
		this.itemVenda = itemVenda;
	}

	public String getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

}
