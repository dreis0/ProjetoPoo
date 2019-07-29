package txtRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.ITxtRepository;
import model.Livro;

public class LivroRepository implements ITxtRepository<Livro> {

	private static final String fileName = "Livros.txt";

	private int id() throws IOException {
		return Utils.getLastId(fileName);
	}

	@Override
	public Livro getById(int id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Livro> get() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		ArrayList<Livro> livros = new ArrayList<Livro>();

		try {
			String line = reader.readLine();
			while (line != null) {
				String[] dados = line.split(";");

				Livro l = new Livro();
				l.setId(Integer.parseInt(dados[0]));
				l.setTitulo(dados[1]);
				l.setAutor(dados[2]);

				livros.add(l);
			}

		} finally {
			reader.close();
		}

		return livros;
	}

	@Override
	public Livro insert(Livro model) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livro update(Livro model) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) throws IOException {
		// TODO Auto-generated method stub

	}

}
