package testeDesenvolvedor;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Main {
	private static BigDecimal maiorVenda;
	private static int idMaiorVenda;
	private static int idItemMaiorVenda;
	private static BigDecimal precoItemMaiorVenda;
	private static BigDecimal qtdItemMaiorVenda;
	private static BigDecimal menorVendaTotal;
	private static BigDecimal totalVenda;
	private static String nomeVendedorMenorVenda;
	private static ArrayList<Vendas> vendasList;
	private static ArrayList<Vendedor> vendedorList;
	private static ArrayList<Cliente> clienteList;
	private static int idPiorVendedor;

	public static void main(String[] args) throws IOException {		
		//Gerar_um_novo_arquivo_binario_de_Dados
		Dados dados = criarDados();		
		Empacotamento.gravarArquivoDadosBinario(dados, "arquivo.dat");
		////////////////////////////////////////////////////////////////			
		ArrayList<Arquivo> arquivosDadosBinarios = Empacotamento.lerArquivosDadosBinarios();
		exibirDados(arquivosDadosBinarios);
		gerarRelatorio(arquivosDadosBinarios);
		ArrayList<Arquivo> arquivosRelatoriosBinarios = Empacotamento.lerArquivosRelatoriosBinarios();
		for(Arquivo arquivo :arquivosRelatoriosBinarios) {
			exibirRelatorio(arquivo.getRelatorio(), arquivo.getNome());			
		}
	}

	private static void exibirRelatorio(Relatorio relatorio, String nomeAquivo) {
		System.out.println("####### Exibindo Relatório: "+nomeAquivo+" #######");
		System.out.println("Quantidade de Clientes: "+relatorio.getQtdClientes());
		System.out.println("Quantidade de Vendedores: "+relatorio.getQtdVendedor());
		System.out.println("Id Venda Mais Cara: "+relatorio.getIdMaiorVenda());
		System.out.println("Id Pior Vendedor: "+relatorio.getIdPiorVendedor());
		System.out.println("Pior Vendedor: "+relatorio.getPiorVendedor());
    	System.out.println("------------------------------------------------------");
		
	}

	private static Dados criarDados() {
		criarListaVendedores();
		criarListaClientes();
		criarListaVendas();
		return new Dados(vendedorList, clienteList, vendasList);		
	}
	
	private static void exibirDados(ArrayList<Arquivo> arquivos) {
		for(Arquivo arquivo : arquivos) {
			System.out.println("####### Exibindo Arquivo: "+arquivo.getNome()+" #######\n");			
			exibirVendedores(arquivo.getDados());
			exibirClientes(arquivo.getDados());
			exibirVendas(arquivo.getDados());
			System.out.println("\n------------------------------------------------------");
		}
	}
	

	private static void criarListaVendas() {
		vendasList = new ArrayList<Vendas>();
		ArrayList<ItemVenda> itenVendaList = new ArrayList<ItemVenda>();
		itenVendaList.add(new ItemVenda(1, new BigDecimal(10), new BigDecimal(100)));
		itenVendaList.add(new ItemVenda(2, new BigDecimal(30), new BigDecimal(2.50)));
		itenVendaList.add(new ItemVenda(3, new BigDecimal(40), new BigDecimal(3.10)));
		vendasList.add(new Vendas(10, itenVendaList,2, "Pedro"));
		itenVendaList = new ArrayList<ItemVenda>();
		itenVendaList.add(new ItemVenda(1, new BigDecimal(10), new BigDecimal(400)));
		itenVendaList.add(new ItemVenda(2, new BigDecimal(20), new BigDecimal(500)));
		itenVendaList.add(new ItemVenda(3, new BigDecimal(30), new BigDecimal(600)));
		vendasList.add(new Vendas(8, itenVendaList,1,"Paulo"));
	}

	private static void criarListaClientes() {
		clienteList = new ArrayList<Cliente>();
		clienteList.add(new Cliente("Jose da Silva", "2345675434544345", new BigDecimal(2000), "Rural"));
		clienteList.add(new Cliente("Eduardo Pereira", "2345675433444345", new BigDecimal(3000), "Rural"));		
	}

	private static void criarListaVendedores() {
		vendedorList = new ArrayList<Vendedor>();
		vendedorList.add(new Vendedor("Pedro", "1234567891234", new BigDecimal(50000)));
		vendedorList.add(new Vendedor("Paulo", "3245678865434", new BigDecimal(40000.99)));		
	}

	private static void gerarRelatorio(ArrayList<Arquivo> arquivos) {
		for(Arquivo arquivo : arquivos) {
			if(arquivo != null && arquivo.getDados() != null) {
				Dados dados = arquivo.getDados();
				if (dados.getVendasList() != null) {
					if (!dados.getVendasList().isEmpty()) {
						initVarCalculoVenda();			
						for (Vendas vendas : dados.getVendasList()) {
							BigDecimal somaItem = new BigDecimal(0);
							totalVenda = new BigDecimal(0);
							ArrayList<String> itens = new ArrayList<String>();
							for (ItemVenda itemVenda : vendas.getItemVenda()) {
								// Multplica_o_valor_do_item_pela_quantidade_vendida
								somaItem = itemVenda.getItemPreco().setScale(2, java.math.RoundingMode.HALF_EVEN)
										.multiply(itemVenda.getItemQuantidade());
								// Busca_Maior_Venda
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
							if (totalVenda.compareTo(menorVendaTotal) < 0 || menorVendaTotal.compareTo(new BigDecimal(0)) == 0) {
								menorVendaTotal = totalVenda;
								nomeVendedorMenorVenda = vendas.getNomeVendedor();
								idPiorVendedor = vendas.getIdVendedor();
							}
						}				
						Relatorio relatorio = new Relatorio(dados.getClienteList().size(),idMaiorVenda, dados.getVendedorList().size(),idPiorVendedor, nomeVendedorMenorVenda);
						String nomeDone = arquivo.getNome().replace(".dat", ".done.dat");
						Empacotamento.gravarArquivoRelatorioBinario(relatorio, nomeDone);
						
					} else {
						System.out.println("Gerar Relatorio - A lista de Vendas está vazia.");			
					}
				}				
			}			
		}
	}
	
	private static void exibirVendas(Dados dados) {
		if (dados.getVendasList() != null) {
			if (!dados.getVendasList().isEmpty()) {
				initVarCalculoVenda();			
				for (Vendas vendas : dados.getVendasList()) {
					BigDecimal somaItem = new BigDecimal(0);
					totalVenda = new BigDecimal(0);
					ArrayList<String> itens = new ArrayList<String>();
					for (ItemVenda itemVenda : vendas.getItemVenda()) {					
						itens.add(itemVenda.getItemId() + "-" + itemVenda.getItemQuantidade() + "-"
								+ NumberFormat.getCurrencyInstance().format(itemVenda.getItemPreco()));
						totalVenda = totalVenda.add(somaItem);
					}
					System.out.println(String.format("%03d", vendas.getId()) + "-" + vendas.getIdVenda() + itens
							+ vendas.getNomeVendedor());					
				}

			} else {
				System.out.println("A lista de Vendas está vazia.");			
			}
		}
	}

	private static void exibirClientes(Dados dados) {
		if (dados.getClienteList() != null) {
			if (!dados.getClienteList().isEmpty()) {
				for (Cliente cliente : dados.getClienteList()) {
					System.out.println(String.format("%03d", cliente.getId()) + "-" + cliente.getCnpj() + "-"
							+ cliente.getNome() + "-" + cliente.getArea());
				}
			} else {
				System.out.println("A lista de Clientes estÃ¡ vazia.");
			}
		}
	}

	private static void exibirVendedores(Dados dados) {
		if (dados.getVendedorList() != null) {
			if (!dados.getVendedorList().isEmpty()) {
				for (Vendedor vendedor : dados.getVendedorList()) {
					System.out.println(String.format("%03d", vendedor.getId()) + "-" + vendedor.getCpf() + "-"
							+ vendedor.getNome() + "-"
							+ NumberFormat.getCurrencyInstance().format(vendedor.getSalario()));
				}
			} else {
				System.out.println("A lista de Vendedores está vazia.");
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
		idPiorVendedor = 0;
	}

	public static int getIdItemMaiorVenda() {
		return idItemMaiorVenda;
	}

	public static void setIdItemMaiorVenda(int idItemMaiorVenda) {
		Main.idItemMaiorVenda = idItemMaiorVenda;
	}

	public static BigDecimal getPrecoItemMaiorVenda() {
		return precoItemMaiorVenda;
	}

	public static void setPrecoItemMaiorVenda(BigDecimal precoItemMaiorVenda) {
		Main.precoItemMaiorVenda = precoItemMaiorVenda;
	}

	public static BigDecimal getQtdItemMaiorVenda() {
		return qtdItemMaiorVenda;
	}

	public static void setQtdItemMaiorVenda(BigDecimal qtdItemMaiorVenda) {
		Main.qtdItemMaiorVenda = qtdItemMaiorVenda;
	}
}
