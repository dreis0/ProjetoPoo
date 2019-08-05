package exceptions;

public class UsuarioJaExisteException extends Exception {

	public UsuarioJaExisteException(String email) {
		super("O " + email + " j� est� cadastrado");
	}
}