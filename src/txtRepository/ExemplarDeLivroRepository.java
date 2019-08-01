package txtRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import exceptions.NotFoundException;
import model.ExemplarDeLivro;
import model.Usuario;
import utils.Strings;

public class ExemplarDeLivroRepository extends BaseRepository<ExemplarDeLivro> {

	public static String fileName = "Exemplares.txt";
	private static ExemplarDeLivroRepository instance;

	private ExemplarDeLivroRepository() throws FileNotFoundException, IOException {
		super(fileName);
	}

	public static ExemplarDeLivroRepository instance() throws FileNotFoundException, IOException {
		if (instance == null)
			instance = new ExemplarDeLivroRepository();
		return instance;
	}

	private int id() throws IOException, FileNotFoundException {
		return Utils.getNextId(fileName);
	}

	@Override
	protected String mapToString(ExemplarDeLivro model) throws IOException, FileNotFoundException {
		int id;
		if (model.getId() == 0)
			id = id();
		else
			id = model.getId();

		return (id + Strings.DELIMITADOR + model.isDisponivel() + Strings.DELIMITADOR + model.isReservado()
				+ Strings.DELIMITADOR + model.getEdicao() + Strings.DELIMITADOR + model.getEditora()
				+ Strings.DELIMITADOR + model.getAnoDeLancamento() + "\n");
	}

	@Override
	protected ExemplarDeLivro mapToModel(String str) throws IOException, FileNotFoundException {
		String[] campos = str.split(Strings.DELIMITADOR);

		ExemplarDeLivro exemplar = new ExemplarDeLivro();

		exemplar.setId(Integer.parseInt(campos[0]));
		exemplar.setDisponivel(Boolean.getBoolean(campos[1]));
		exemplar.setReservado(Boolean.getBoolean(campos[2]));
		exemplar.setEdicao(Integer.parseInt(campos[3]));
		exemplar.setEditora(campos[4]);
		exemplar.setAnoDeLancamento(Integer.parseInt(campos[5]));

		return exemplar;
	}

	@Override
	public ExemplarDeLivro getById(int id)
			throws IOException, FileNotFoundException, NotFoundException, ParseException {

		ArrayList<ExemplarDeLivro> livros = get();

		for (ExemplarDeLivro l : livros) {
			if (l.getId() == id)
				return l;
		}

		throw new NotFoundException("Usuário");
	}

	@Override
	public ArrayList<ExemplarDeLivro> get() throws IOException, FileNotFoundException, ParseException {

		ArrayList<ExemplarDeLivro> exemplares = new ArrayList<ExemplarDeLivro>();

		String currentLine;
		reader = new BufferedReader(new FileReader(fileName));

		while ((currentLine = reader.readLine()) != null) {
			exemplares.add(mapToModel(currentLine));
		}

		return exemplares;
	}

	@Override
	public ExemplarDeLivro insert(ExemplarDeLivro model) throws IOException, FileNotFoundException {
		writer.append(mapToString(model));

		return model;
	}

	@Override
	public ExemplarDeLivro update(ExemplarDeLivro model) throws IOException, FileNotFoundException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) throws IOException, ParseException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void insertAll(ArrayList<ExemplarDeLivro> list) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub

	}

	@Override
	public void close() throws Exception {
		super.close();
		instance = null;
	}
}
