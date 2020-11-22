package testeDesenvolvedor;

import java.io.Serializable;
import java.util.List;

public class Dados implements Serializable{
	private static final long serialVersionUID = -3817588681470836788L;
	private List<Vendedor> vendedorList;
	private List<Cliente> clienteList;
	private List<Vendas> vendasList;
	
	public Dados (List<Vendedor>  vendedorList, List<Cliente> clienteList, List<Vendas> vendasList) {
		this.vendedorList = vendedorList;
		this.clienteList = clienteList;
		this.vendasList = vendasList;
	}

	public List<Vendedor> getVendedorList() {
		return vendedorList;
	}

	public void setVendedorList(List<Vendedor> vendedorList) {
		this.vendedorList = vendedorList;
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

	public List<Vendas> getVendasList() {
		return vendasList;
	}

	public void setVendasList(List<Vendas> vendasList) {
		this.vendasList = vendasList;
	}

}
