package txtRepository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.ITxtRepository;
import model.Usuario;
import model.Bibliotecario;
import model.Master;
import model.TipoDeUsuario;

public class UsuarioRepository implements ITxtRepository<Usuario> {

	private static final String fileName = "Usuarios.txt";

	private int id() throws IOException {
		return Utils.getNextId(fileName);
	}

	@Override
	public Usuario getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Usuario> get() throws FileNotFoundException, IOException {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		try {
			String currentLine = reader.readLine();

			while (currentLine != null) {
				String[] fields = currentLine.split(";");

				Usuario user = Utils.instance(Utils.ToEnum(fields[2]));
				user.setId(Integer.parseInt(fields[0]));
				user.setNome(fields[1]);
				user.setEmail(fields[3]);
				user.setSenha(fields[4]);
				user.setMultaAte(new Date());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public Usuario insert(Usuario model) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

		model.setId(id());

		try {
			writer.write(model.getId() + " ;");
			writer.write(model.getNome() + " ;");
			writer.write(model.getTipo().ordinal() + " ;");
			writer.write(model.getEmail() + " ;");
			writer.write(model.getSenha() + " ;");
			writer.write(model.getMultaAte() + " ;");
			writer.write(model.getDocumento() + "\n");

		} finally {
			writer.close();
		}

		return model;
	}

	@Override
	public Usuario update(Usuario model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

}
