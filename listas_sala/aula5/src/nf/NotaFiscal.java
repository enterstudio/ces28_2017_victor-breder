package nf;

import java.util.ArrayList;

public class NotaFiscal {
	
	private String numero;
	private int valor;
	private Cliente cliente;
	
	private ArrayList<ItemDeVenda> items;
	
	public NotaFiscal(Cliente cliente, VerificadorCPF verificadorCPF) {
		this.cliente = cliente;
		if (!verificadorCPF.verificar(cliente.getCPF())) {
			throw new IllegalArgumentException("O Cliente possui CPF inválido ou comprometido no SPC");
		}
		
		items = new ArrayList<ItemDeVenda>();
	}
	
	public void addItem(ItemInterface item, int quantidade) {
		items.add(new ItemDeVenda(item, quantidade));
	}
	
	public void getItem(int i) {
		items.get(i);
	}
	
	public void updateItem(int i, ItemDeVenda item) {
		items.set(i, item);
	}
	
	public void removeItem(int i) {
		items.remove(i);
	}
	
	public int getItemCount() {
		return items.size();
	}
	
	public int getValorTotal() {
		int total = 0;
		for (ItemDeVenda item : items) {
			total += item.getValor();
		}
		return total;
	}

}
