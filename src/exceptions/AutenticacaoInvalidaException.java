package exceptions;

public class AutenticacaoInvalidaException extends Exception {

	public AutenticacaoInvalidaException() {
		super("Usuário e/ou senha inválido(s)");
	}

}
