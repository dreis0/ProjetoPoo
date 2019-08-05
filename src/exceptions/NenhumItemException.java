package exceptions;

public class NenhumItemException extends Exception {

	public NenhumItemException(String tipoItem) {
		super("Nenhum " + tipoItem + "encontrado");
	}

}
