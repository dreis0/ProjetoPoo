package txtRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import model.Emprestimo;
import utils.DateUtils;
import utils.Strings;

public class EmprestimoRepository extends BaseRepository<Emprestimo> {

	private static EmprestimoRepository instance;

	private EmprestimoRepository() throws FileNotFoundException, IOException {
		super("Emprestimos.txt");
	}

	public static EmprestimoRepository instance() throws FileNotFoundException, IOException {
		if (instance == null)
			instance = new EmprestimoRepository();
		return instance;
	}

	@Override
	protected int id() throws IOException, FileNotFoundException {
		return Utils.getNextId(fileName);
	}

	@Override
	protected String mapToFieldsString(Emprestimo model) throws IOException, FileNotFoundException {
		int id;
		if (model.getId() == 0)
			id = id();
		else
			id = model.getId();

		return id + Strings.DELIMITADOR + model.getUsuarioId() + Strings.DELIMITADOR + model.getExemplarId()
				+ Strings.DELIMITADOR + model.getDataDeEmprestimo().format(DateUtils.FORMATO_PADRAO)
				+ Strings.DELIMITADOR + model.getPrazoDeDevolucao() + Strings.DELIMITADOR
				+ model.getDataDaDevolucao().format(DateUtils.FORMATO_PADRAO) + "\n";
	}

	@Override
	protected Emprestimo mapToModel(String fieldsString) throws IOException, FileNotFoundException, ParseException {

		String[] fields = fieldsString.split(Strings.DELIMITADOR);

		Emprestimo emprestimo = new Emprestimo();

		emprestimo.setId(Integer.parseInt(fields[0]));
		emprestimo.setUsuarioId(Integer.parseInt(fields[1]));
		emprestimo.setExemplarId(Integer.parseInt(fields[2]));
		emprestimo.setDataDeEmprestimo(fields[3]);
		emprestimo.setPrazoDeDevolucao(Integer.parseInt(fields[4]));
		emprestimo.setDataDaDevolucao(fields[5]);

		return emprestimo;
	}

	@Override
	public void close() throws Exception {
		super.close();
		instance = null;
	}
}
