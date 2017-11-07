package ProdutoServico;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
	private List<Component> componentes;
	
	public Composite() {
		componentes = new ArrayList<Component>();
	}
	
	public void addComponent(Component componente) {
		componentes.add(componente);
	}
}
