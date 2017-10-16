package so;

import java.util.Observable;
import java.util.Observer;

import rn.Usuario;

public class SistemaCliente implements Observer {
	
	private Usuario usuario;

	public SistemaCliente(Usuario usuario) {
		this.usuario = usuario;
		usuario.addObserver(this);
	}

	public void setUsuarioState(String state) {
		usuario.setState(state);
	}
	
	// metodo push
	public void update(Observable observable, Object state) {
		System.out.println("SistemaCliente: " + (String) state);
	}

}
