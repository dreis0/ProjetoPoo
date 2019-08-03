package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import exceptions.ExemplarSemPaiException;
import exceptions.NotFoundException;
import model.ExemplarDeLivro;
import model.Livro;

public interface IBibliotecarioActions {
	
	public void cadastrarLivro(Livro livro) throws FileNotFoundException, IOException;
	
	public void cadastrarExemplar(ExemplarDeLivro exemplar) throws FileNotFoundException, IOException, ParseException, ExemplarSemPaiException;
	
	public void removerLivro(Livro livro) throws NotFoundException, IOException, ParseException;
	
	public void removerExemplar(ExemplarDeLivro exemplar) throws NotFoundException, IOException, ParseException;
}
