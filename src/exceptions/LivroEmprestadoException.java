package exceptions;

public class LivroEmprestadoException extends Exception {

	public LivroEmprestadoException() {
		super("Não é possível excluir um livro que está emprestado");
	}

}
