package nf;

public class ItemDeVenda {
	
	private ItemInterface item;
	private int quantidade;

	public ItemDeVenda(ItemInterface item, int quantidade) {
		this.item = item;
		this.quantidade = quantidade;
	}
	
	int getValor() {
		return item.getPreco() * quantidade;
	}

}
