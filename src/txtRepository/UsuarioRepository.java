package txtRepository;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import exceptions.NotFoundException;
import interfaces.ITxtRepository;
import model.Usuario;
import utils.Strings;

public class UsuarioRepository extends BaseRepository<Usuario> implements ITxtRepository<Usuario> {

	private static final String fileName = "Usuarios.txt";
	private static UsuarioRepository instance;

	private UsuarioRepository() throws IOException, FileNotFoundException {
		super(fileName);
	}

	public static UsuarioRepository instance() throws FileNotFoundException, IOException {
		if (instance == null)
			instance = new UsuarioRepository();
		return instance;
	}

	private int id() throws IOException {
		return Utils.getNextId(fileName);
	}

	@Override
	public Usuario getById(int id) throws FileNotFoundException, IOException, NotFoundException, ParseException {
		ArrayList<Usuario> usuarios = get();

		for (Usuario u : usuarios) {
			if (u.getId() == id)
				return u;
		}

		throw new NotFoundException("Usu�rio");
	}

	@Override
	public ArrayList<Usuario> get()
			throws FileNotFoundException, IOException, IllegalArgumentException, ParseException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		String currentLine;

		while ((currentLine = reader.readLine()) != null) {
			String[] fields = currentLine.split(Strings.DELIMITADOR);

			Usuario u = Utils.instance(Utils.ToEnum(fields[2]));
			u.setId(Integer.parseInt(fields[0]));
			u.setNome(fields[1]);
			u.setEmail(fields[3]);
			u.setSenha(fields[4]);
			u.setMultaAte(fields[5]);
			u.setDocumento(fields[6]);

			usuarios.add(u);
		}

		return usuarios;
	}

	public Usuario insert(Usuario model) throws IOException {
		System.out.println("insert");

		writer.append(id() + Strings.DELIMITADOR + model.getNome() + Strings.DELIMITADOR + model.getTipo().ordinal()
				+ Strings.DELIMITADOR + model.getEmail() + Strings.DELIMITADOR + model.getSenha() + Strings.DELIMITADOR
				+ model.getMultaAte() + Strings.DELIMITADOR + model.getDocumento() + "\n");

		return model;
	}

	@Override
	protected void insertAll(ArrayList<Usuario> usuarios) throws IOException, FileNotFoundException {
		File usuariosFile = new File("Usuarios.txt");

		BufferedWriter writer = new BufferedWriter(new FileWriter(usuariosFile));

		for (Usuario u : usuarios) {
			writer.append(u.getId() + Strings.DELIMITADOR + u.getNome() + Strings.DELIMITADOR + u.getTipo().ordinal()
					+ Strings.DELIMITADOR + u.getEmail() + Strings.DELIMITADOR + u.getSenha() + Strings.DELIMITADOR
					+ u.getMultaAte() + Strings.DELIMITADOR + u.getDocumento() + "\n");
		}

		writer.close();
		usuariosFile.delete();
	}

	@Override
	public Usuario update(Usuario model) throws IOException, FileNotFoundException, ParseException {
		ArrayList<Usuario> usuarios = get();

		for (Usuario u : usuarios) {
			if (u.getId() != model.getId()) {
				writer.write(u.getId() + ";");
				writer.write(u.getNome() + ";");
				writer.write(u.getTipo().ordinal() + ";");
				writer.write(u.getEmail() + ";");
				writer.write(u.getSenha() + ";");
				writer.write(u.getMultaAte() + ";");
				writer.write(u.getDocumento() + "\n");
			} else {
				writer.write(model.getId() + ";");
				writer.write(model.getNome() + ";");
				writer.write(model.getTipo().ordinal() + ";");
				writer.write(model.getEmail() + ";");
				writer.write(model.getSenha() + ";");
				writer.write(model.getMultaAte() + ";");
				writer.write(model.getDocumento() + "\n");
			}
		}
		return model;
	}

	@Override
	public void deleteById(int id) throws IOException, FileNotFoundException, ParseException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		String currentLine;

		while ((currentLine = reader.readLine()) != null) {
			String[] fields = currentLine.split(Strings.DELIMITADOR);

			Usuario u = Utils.instance(Utils.ToEnum(fields[2]));
			if (Integer.parseInt(fields[0]) == id)
				continue;

			u.setId(Integer.parseInt(fields[0]));
			u.setNome(fields[1]);
			u.setEmail(fields[3]);
			u.setSenha(fields[4]);
			u.setMultaAte(fields[5]);
			u.setDocumento(fields[6]);

			usuarios.add(u);
		}

		insertAll(usuarios);
	}

	@Override
	public void close() throws Exception {
		super.close();
		instance = null;
	}
}
