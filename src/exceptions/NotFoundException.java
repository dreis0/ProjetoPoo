package exceptions;

public class NotFoundException extends Exception {

	public NotFoundException(String item) {
		super(item + " n�o encontrado");
	}

}
