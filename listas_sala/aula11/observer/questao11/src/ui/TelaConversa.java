package ui;

import rn.Usuario;
import util.Observer;

public class TelaConversa extends Observer {
	
	private Usuario usuario;
	
	public TelaConversa(Usuario usuario) {
		 this.usuario = usuario;
		 usuario.attach(this);
	}

	public void update() {
		System.out.println("TelaConversa: " + usuario.getState());
	}

}
