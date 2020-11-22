package testeDesenvolvedor;

import java.io.Serializable;
import java.math.BigDecimal;


public class ItemVenda implements Serializable {
	private static final long serialVersionUID = 3598563527086722138L;
	private String itemId;
	private BigDecimal itemQuantidade;
	private BigDecimal itemPreco;


	public ItemVenda(String itemId, BigDecimal itemQuantidade, BigDecimal itemPreco) {
		this.itemId = itemId;
		this.itemQuantidade = itemQuantidade;
		this.itemPreco = itemPreco;		
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public BigDecimal getItemQuantidade() {
		return itemQuantidade;
	}


	public void setItemQuantidade(BigDecimal itemQuantidade) {
		this.itemQuantidade = itemQuantidade;
	}


	public BigDecimal getItemPreco() {
		return itemPreco;
	}


	public void setItemPreco(BigDecimal itemPreco) {
		this.itemPreco = itemPreco;
	}


}
