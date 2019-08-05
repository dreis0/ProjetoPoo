package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import exceptions.NenhumItemException;
import exceptions.NotFoundException;
import model.ExemplarDeLivro;
import model.Livro;

public interface IBibliotecaActions extends AutoCloseable {

	public ExemplarDeLivro getExemplarById(int id)
			throws FileNotFoundException, IOException, NotFoundException, ParseException;

	public Livro getlivroById(int id) throws FileNotFoundException, IOException, NotFoundException, ParseException;

	public ArrayList<Livro> getLivros() throws FileNotFoundException, IOException, ParseException, NenhumItemException;

	public ArrayList<Livro> getLivrosDisponiveis()
			throws IOException, FileNotFoundException, ParseException, NenhumItemException;
}
