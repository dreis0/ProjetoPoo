package exceptions;

public class LimiteDeLivrosAtingidosException extends Exception {

	public LimiteDeLivrosAtingidosException(int limiteDeLivrosQuePodeAlugar) {
		super("Esse usuário pode alugar até " + limiteDeLivrosQuePodeAlugar);
		// TODO Auto-generated constructor stub
	}
}
