package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import model.Livro;

public interface IBibliotecaActions extends AutoCloseable {

	public ArrayList<Livro> getLivrosDisponiveis() throws IOException, FileNotFoundException, ParseException;
}
