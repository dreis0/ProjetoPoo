package exceptions;

public class LivroEmprestadoException extends Exception {

	public LivroEmprestadoException() {
		super("N�o � poss�vel excluir um livro que est� emprestado");
	}

}
