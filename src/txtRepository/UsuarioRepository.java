package txtRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import interfaces.IRepository;
import model.Usuario;
import utils.DateUtils;
import utils.Strings;

public class UsuarioRepository extends BaseRepository<Usuario> implements IRepository<Usuario> {

	private static UsuarioRepository instance;

	private UsuarioRepository() throws IOException, FileNotFoundException {
		super("Usuarios.txt");
	}

	public static UsuarioRepository instance() throws FileNotFoundException, IOException {
		if (instance == null)
			instance = new UsuarioRepository();
		return instance;
	}

	@Override
	protected int id() throws IOException, FileNotFoundException {
		return Utils.getNextId(fileName);
	}

	@Override
	protected String mapToFieldsString(Usuario model) throws IOException, FileNotFoundException {
		int id;
		if (model.getId() == 0)
			id = id();
		else
			id = model.getId();

		return id + Strings.DELIMITADOR + model.getNome() + Strings.DELIMITADOR + model.getTipo().ordinal()
				+ Strings.DELIMITADOR + model.getEmail() + Strings.DELIMITADOR + model.getSenha() + Strings.DELIMITADOR
				+ model.getMultaAte().format(DateUtils.FORMATO_PADRAO) + Strings.DELIMITADOR + model.getDocumento()
				+ "\n";
	}

	@Override
	protected Usuario mapToModel(String fieldsString) throws IOException, FileNotFoundException, ParseException {
		String[] fields = fieldsString.split(Strings.DELIMITADOR);

		Usuario u = Utils.instance(Utils.ToEnum(fields[2]));
		u.setId(Integer.parseInt(fields[0]));
		u.setNome(fields[1]);
		u.setEmail(fields[3]);
		u.setSenha(fields[4]);
		u.setMultaAte(fields[5]);
		u.setDocumento(fields[6]);

		return u;
	}

	@Override
	public void close() throws Exception {
		super.close();
		instance = null;
	}
}
