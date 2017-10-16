package so;

import rn.Usuario;
import util.Observer;

public class SistemaCliente extends Observer {
	
	private Usuario usuario;
	
	public SistemaCliente(Usuario usuario) {
		this.usuario = usuario;
		usuario.attach(this);
	}

	public void update() {
		System.out.println("SistemaCliente: " + usuario.getState());
	}
	
	public void setUsuarioState(String state) {
		usuario.setState(state);
	}

}
