package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import exceptions.ExemplarSemPaiException;
import exceptions.LivroEmprestadoException;
import exceptions.NotFoundException;
import model.ExemplarDeLivro;
import model.Livro;

public interface IBibliotecarioActions extends AutoCloseable {

	public void cadastrarLivro(Livro livro) throws FileNotFoundException, IOException;

	public void cadastrarExemplar(ExemplarDeLivro exemplar)
			throws FileNotFoundException, IOException, ParseException, ExemplarSemPaiException;

	public void removerLivro(Livro livro)
			throws NotFoundException, IOException, ParseException, LivroEmprestadoException;

	public void removerExemplar(ExemplarDeLivro exemplar) throws NotFoundException, IOException, ParseException, LivroEmprestadoException;
}
