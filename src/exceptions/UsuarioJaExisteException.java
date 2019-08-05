package exceptions;

public class UsuarioJaExisteException extends Exception {

	public UsuarioJaExisteException(String email) {
		super("O " + email + " já está cadastrado");
	}
}