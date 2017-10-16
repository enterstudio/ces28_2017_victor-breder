package main;

import rn.Usuario;
import so.SistemaCliente;
import ui.TelaConversa;

public class Main {

	public static void main(String[] args) {
		Usuario usuario = new Usuario();
		TelaConversa telaConversa1 = new TelaConversa(usuario);
		TelaConversa telaConversa2 = new TelaConversa(usuario);
		SistemaCliente sistemaCliente = new SistemaCliente(usuario);
		
		sistemaCliente.setUsuarioState("hue");
		sistemaCliente.setUsuarioState("br");
	}

}
