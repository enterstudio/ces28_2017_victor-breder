package NotaFiscal;

import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {
	private boolean fechada;
	private List<ItemVenda> itens;
	private int id;

	public NotaFiscal() {
		itens = new ArrayList<ItemVenda>();
		fechada = false;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (!fechada) {
			this.id = id;
		} else {
			System.out.println("O ID de uma nota fechada não pode ser modificado.");
		}
	}

	public void adicionaItemVenda(ItemVenda item) {
		if (!fechada) {
			itens.add(item);
		} else {
			System.out.println("O item não pode ser adicionado");
		}
	}

	public int getItemCount() {
		return itens.size();
	}
	
	public boolean isFechada() {
		return fechada;
	}

	public void fechar() {
		if (!fechada) {
			fechada = true;
			if (ValidadorNF.validar(this)) {
				id = ValidadorNF.getNextId();
			}
		}
	}

	public void imprimir() {
		if (fechada) {
			for (ItemVenda item : itens)
				;
			// Imprimir itens e valores
			// Valor dos impostos
			// Valor total
		} else {
			System.out.println("A nota fiscal não pode ser impressa se ela não tiver fechada");
		}
	}
}
