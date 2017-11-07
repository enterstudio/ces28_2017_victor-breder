package NotaFiscal;

public class ValidadorNF {
	private static int nextId = 1;
	
	public static boolean validar(NotaFiscal notaFiscal) {
		if (notaFiscal.getItemCount() > 0) {
			notaFiscal.setId(getNextId());
			return true;
		}
		return false;
	}
	
	public static int getNextId() {
		return nextId++;
	}
}
