package exceptions;

public class AutenticacaoInvalidaException extends Exception {

	public AutenticacaoInvalidaException() {
		super("Usu�rio e/ou senha inv�lido(s)");
	}

}
