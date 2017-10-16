package ui;

import java.util.Observable;
import java.util.Observer;

import rn.Usuario;

public class TelaConversa implements Observer {

	private Usuario usuario;
	
	public TelaConversa(Usuario usuario) {
		this.usuario = usuario;
		usuario.addObserver(this);
	}

	// metodo pull
	public void update(Observable observable, Object state) {
		if (observable == usuario) {
			System.out.println("TelaConversa: " + usuario.getState());
		}
	}

}
