package Q4.letraC;

import java.util.Iterator;

public class Calculadora {
	
	public float calculaTotalDespesas(Iterator<Despesa> despesas) {
		float total = 0.0f;
		while (despesas.hasNext()) {
			Despesa despesa = despesas.next();
			float valor = despesa.getValor();
			total += valor;
		}
		return total;
	}
	
}
