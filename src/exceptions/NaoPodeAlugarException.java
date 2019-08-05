package exceptions;

public class NaoPodeAlugarException extends Exception {

	public NaoPodeAlugarException() {
		super("Esse usu�rio est� bloqueado de fazer novos empr�stimos");
	}
	
	public NaoPodeAlugarException(int diasRestantesDeMulta) {
		super("Esse usu�rio est� bloqueado de fazer novos empr�stimos por mais " + diasRestantesDeMulta + "dias");
	}


}
