package exceptions;

public class NaoPodeAlugarException extends Exception {

	public NaoPodeAlugarException() {
		super("Esse usuário está bloqueado de fazer novos empréstimos");
	}
	
	public NaoPodeAlugarException(int diasRestantesDeMulta) {
		super("Esse usuário está bloqueado de fazer novos empréstimos por mais " + diasRestantesDeMulta + "dias");
	}


}
