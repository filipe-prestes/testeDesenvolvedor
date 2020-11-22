package testeDesenvolvedor;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static BigDecimal maiorVenda;
	private static int idMaiorVenda;
	private static int idItemMaiorVenda;
	private static BigDecimal precoItemMaiorVenda;
	private static BigDecimal qtdItemMaiorVenda;
	private static BigDecimal menorVendaTotal;
	private static BigDecimal totalVenda;
		private static String nomeVendedorMenorVenda;

	public static void main(String[] args) {
		gravarDados();
		exibirDados();
	}

	private static void gravarDados() {
		List<Vendedor> vendedorList = new ArrayList<Vendedor>();
		vendedorList.add(new Vendedor("Pedro", "1234567891234", new BigDecimal(50000)));
		vendedorList.add(new Vendedor("Paulo", "3245678865434", new BigDecimal(40000.99)));

		List<Cliente> clienteList = new ArrayList<Cliente>();
		clienteList.add(new Cliente("Jose da Silva", "2345675434544345", new BigDecimal(2000), "Rural"));
		clienteList.add(new Cliente("Eduardo Pereira", "2345675433444345", new BigDecimal(3000), "Rural"));

		List<Vendas> vendasList = new ArrayList<Vendas>();

		ArrayList<ItemVenda> itenVendaList = new ArrayList<ItemVenda>();
		itenVendaList.add(new ItemVenda(1, new BigDecimal(10), new BigDecimal("100")));
		itenVendaList.add(new ItemVenda(2, new BigDecimal(30), new BigDecimal("2.50")));
		itenVendaList.add(new ItemVenda(3, new BigDecimal(40), new BigDecimal("3.10")));
		vendasList.add(new Vendas(10, itenVendaList, "Pedro"));

		itenVendaList = new ArrayList<ItemVenda>();
		itenVendaList.add(new ItemVenda(1, new BigDecimal(10), new BigDecimal(400)));
		itenVendaList.add(new ItemVenda(2, new BigDecimal(20), new BigDecimal(500)));
		itenVendaList.add(new ItemVenda(3, new BigDecimal(30), new BigDecimal(600)));
		vendasList.add(new Vendas(8, itenVendaList, "Paulo"));

		Dados dados = new Dados(vendedorList, clienteList, vendasList);
		Empacotamento.gravarArquivoBinario(dados);
	}

	private static void exibirDados() {
		Dados dados = Empacotamento.lerArquivoBinario();
		if (dados != null) {
			if (dados.getVendedorList() != null) {
				if (!dados.getVendedorList().isEmpty()) {
					for (Vendedor vendedor : dados.getVendedorList()) {
						System.out.println(String.format("%03d", vendedor.getId()) + "-" + vendedor.getCpf() + "-"
								+ vendedor.getNome() + "-"
								+ NumberFormat.getCurrencyInstance().format(vendedor.getSalario()));
					}
				}else {
					System.out.println("A lista de Vendedores está vazia.");
				}
			}

			if (dados.getClienteList() != null) {
				if (!dados.getClienteList().isEmpty()) {
					for (Cliente cliente : dados.getClienteList()) {
						System.out.println(String.format("%03d", cliente.getId()) + "-" + cliente.getCnpj() + "-"
								+ cliente.getNome() + "-" + cliente.getArea());
					}
				}else {
					System.out.println("A lista de Clientes está vazia.");
				}
			}

			if (dados.getVendasList() != null) {
				if (!dados.getVendasList().isEmpty()) {
					initVarCalculoVenda();				
					for (Vendas vendas : dados.getVendasList()) {
						BigDecimal somaItem = new BigDecimal(0);				
						totalVenda = new BigDecimal(0);
						ArrayList<String> itens = new ArrayList<String>();
						for (ItemVenda itemVenda : vendas.getItemVenda()) {
							//Multplica_o_valor_do_item_pela_quantidade_vendida
							somaItem = itemVenda.getItemPreco().setScale(2, java.math.RoundingMode.HALF_EVEN).multiply(itemVenda.getItemQuantidade());
							//Busca_Maior_Venda						
							if (maiorVenda.compareTo(somaItem) < 0) {
								idMaiorVenda = vendas.getIdVenda();
								idItemMaiorVenda = itemVenda.getItemId();
								precoItemMaiorVenda = itemVenda.getItemPreco();
								qtdItemMaiorVenda = itemVenda.getItemQuantidade();
								maiorVenda = somaItem;
							}
							itens.add(itemVenda.getItemId() + "-" + itemVenda.getItemQuantidade() + "-"
									+ NumberFormat.getCurrencyInstance().format(itemVenda.getItemPreco()));
							totalVenda = totalVenda.add(somaItem);
						} 
						System.out.println(String.format("%03d", vendas.getId()) + "-" + vendas.getIdVenda() + itens
								+ vendas.getNomeVendedor());
						if(totalVenda.compareTo(menorVendaTotal) < 0 || menorVendaTotal.compareTo(new BigDecimal(0)) == 0){
							menorVendaTotal = totalVenda;	
							nomeVendedorMenorVenda = vendas.getNomeVendedor();
						}
					}
										
					System.out.println("------------------------------------------------------");
					System.out.println("Maior Venda"
							+"\nId:"+idMaiorVenda
							+"\nItem:"+idItemMaiorVenda
							+"\nQuantidade:"+qtdItemMaiorVenda
							+"\nValor:"+NumberFormat.getCurrencyInstance().format(precoItemMaiorVenda)
							+"\nTotal:"+NumberFormat.getCurrencyInstance().format(maiorVenda));
					System.out.println("------------------------------------------------------");
					System.out.println("Pior Vendedor:"+nomeVendedorMenorVenda);
					System.out.println("Venda Total:"+NumberFormat.getCurrencyInstance().format(menorVendaTotal));
					System.out.println("------------------------------------------------------");
					
				}else {
					System.out.println("A lista de Vendas está vazia.");
				}
			}
		}
	}

	private static void initVarCalculoVenda() {
		menorVendaTotal = new BigDecimal(0);
		totalVenda = new BigDecimal(0);
		maiorVenda = new BigDecimal(0);
		idMaiorVenda = 0;
		idItemMaiorVenda = 0;
		precoItemMaiorVenda = new BigDecimal(0);
		qtdItemMaiorVenda = new BigDecimal(0);
		nomeVendedorMenorVenda = ""; 
	}
}
