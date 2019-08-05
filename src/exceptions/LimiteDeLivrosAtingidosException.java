package exceptions;

public class LimiteDeLivrosAtingidosException extends Exception {

	public LimiteDeLivrosAtingidosException(int limiteDeLivrosQuePodeAlugar) {
		super("Esse usu�rio pode alugar at� " + limiteDeLivrosQuePodeAlugar);
		// TODO Auto-generated constructor stub
	}
}
