package exceptions;

public class ExemplarSemPaiException extends Exception {

	public ExemplarSemPaiException() {
		super("O título ao qual esse exemplar se refere não está cadastrado");
	}
}
