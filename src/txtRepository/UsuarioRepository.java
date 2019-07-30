package txtRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import exceptions.NotFoundException;
import interfaces.ITxtRepository;
import model.Usuario;

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
	public Usuario getById(int id) throws FileNotFoundException, IOException, NotFoundException {
		ArrayList<Usuario> usuarios = get();

		for (Usuario u : usuarios) {
			if (u.getId() == id)
				return u;
		}

		throw new NotFoundException("Usuário");
	}

	@Override
	public ArrayList<Usuario> get() throws FileNotFoundException, IOException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		String currentLine = reader.readLine();

		while (currentLine != null) {
			String[] fields = currentLine.split(";");

			Usuario u = Utils.instance(Utils.ToEnum(fields[2]));
			u.setId(Integer.parseInt(fields[0]));
			u.setNome(fields[1]);
			u.setEmail(fields[3]);
			u.setSenha(fields[4]);
			u.setMultaAte(new Date(fields[5]));

			usuarios.add(u);
		}

		return usuarios;
	}

	public Usuario insert(Usuario model) throws IOException {
		System.out.println("insert");
		ArrayList<Usuario> usuarios = get();

		for (Usuario u : usuarios) {
			writer.write(u.getId() + ";");
			writer.write(u.getNome() + ";");
			writer.write(u.getTipo().ordinal() + ";");
			writer.write(u.getEmail() + ";");
			writer.write(u.getSenha() + ";");
			writer.write(u.getMultaAte() + ";");
			writer.write(u.getDocumento() + "\n");
		}

		writer.write(id() + ";");
		writer.write(model.getNome() + ";");
		writer.write(model.getTipo().ordinal() + ";");
		writer.write(model.getEmail() + ";");
		writer.write(model.getSenha() + ";");
		writer.write(model.getMultaAte() + ";");
		writer.write(model.getDocumento() + "\n");

		return model;
	}

	@Override
	public Usuario update(Usuario model) throws IOException, FileNotFoundException {
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
	public void deleteById(int id) throws IOException, FileNotFoundException {
		ArrayList<Usuario> usuarios = get();

		for (Usuario u : usuarios) {
			if (u.getId() != id) {
				writer.write(u.getId() + ";");
				writer.write(u.getNome() + ";");
				writer.write(u.getTipo().ordinal() + ";");
				writer.write(u.getEmail() + ";");
				writer.write(u.getSenha() + ";");
				writer.write(u.getMultaAte() + ";");
				writer.write(u.getDocumento() + "\n");
			}
		}
	}

	@Override
	public void close() throws Exception {
		super.close();
		instance = null;
	}
}
