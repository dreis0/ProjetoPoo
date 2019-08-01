package txtRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import exceptions.NotFoundException;
import model.Livro;
import utils.Strings;

public class LivroRepository extends BaseRepository<Livro> {

	private static LivroRepository instance;

	private LivroRepository() throws IOException, FileNotFoundException {
		super("Livros.txt");
	}

	public static LivroRepository instance() throws IOException, FileNotFoundException {
		if (instance == null)
			instance = new LivroRepository();
		return instance;
	}

	@Override
	protected int id() throws IOException, FileNotFoundException {
		return Utils.getNextId(fileName);
	}

	@Override
	protected String mapToFieldsString(Livro model) throws IOException, FileNotFoundException {
		int id;
		if(model.getId() == 0)
			id = id();
		else id = model.getId();  
				
		return id + Strings.DELIMITADOR + model.getTitulo() + Strings.DELIMITADOR + model.getAutor() + "\n";
	}

	@Override
	protected Livro mapToModel(String fieldsString) throws IOException, FileNotFoundException, ParseException {
		Livro livro = new Livro();
		String[] fields = fieldsString.split(Strings.DELIMITADOR);

		livro.setId(Integer.parseInt(fields[0]));
		livro.setTitulo(fields[1]);
		livro.setAutor(fields[2]);

		return livro;
	}

	@Override
	public void close() throws Exception {
		super.close();
		instance = null;
	}
}
