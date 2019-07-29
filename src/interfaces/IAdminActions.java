package interfaces;

import model.ExemplarDeLivro;
import model.Livro;

public interface IAdminActions {
	
	public void cadastrarLivro(Livro livro);
	
	public void cadastrarExemplar(ExemplarDeLivro exemplar);
	
	public void removerLivro(Livro livro);
	
	public void removerExemplar(ExemplarDeLivro exemplar);
}
