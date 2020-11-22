package testeDesenvolvedor;

import java.io.Serializable;
import java.math.BigDecimal;


public class ItemVenda implements Serializable {
	private static final long serialVersionUID = 3598563527086722138L;
	private int itemId;
	private BigDecimal itemQuantidade;
	private BigDecimal itemPreco;


	public ItemVenda(int itemId, BigDecimal itemQuantidade, BigDecimal itemPreco) {
		this.itemId = itemId;
		this.itemQuantidade = itemQuantidade;
		this.itemPreco = itemPreco;		
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
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
