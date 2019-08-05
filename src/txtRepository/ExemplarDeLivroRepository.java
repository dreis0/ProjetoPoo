package txtRepository;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.ExemplarDeLivro;
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

	@Override
	protected int id() throws IOException, FileNotFoundException {
		return Utils.getNextId(fileName);
	}

	@Override
	protected String mapToFieldsString(ExemplarDeLivro model) throws IOException, FileNotFoundException {
		int id;
		if (model.getId() == 0)
			id = id();
		else
			id = model.getId();

		return (id + Strings.DELIMITADOR + model.getLivroId() + Strings.DELIMITADOR + model.isDisponivel()
				+ Strings.DELIMITADOR + model.isReservado() + Strings.DELIMITADOR + model.getEdicao()
				+ Strings.DELIMITADOR + model.getEditora() + Strings.DELIMITADOR + model.getAnoDeLancamento() + "\n");
	}

	@Override
	protected ExemplarDeLivro mapToModel(String str) throws IOException, FileNotFoundException {
		String[] campos = str.split(Strings.DELIMITADOR);

		ExemplarDeLivro exemplar = new ExemplarDeLivro();

		boolean disponivel = campos[2].equals("true");
		boolean res = campos[3].equals("true");

		exemplar.setId(Integer.parseInt(campos[0]));
		exemplar.setLivroId(Integer.parseInt(campos[1]));
		exemplar.setDisponivel(disponivel);
		exemplar.setReservado(res);
		exemplar.setEdicao(Integer.parseInt(campos[4]));
		exemplar.setEditora(campos[5]);
		exemplar.setAnoDeLancamento(Integer.parseInt(campos[6]));

		return exemplar;
	}

	@Override
	public void close() throws Exception {
		super.close();
		instance = null;
	}
}
