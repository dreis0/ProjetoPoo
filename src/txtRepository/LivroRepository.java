package txtRepository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.NotFoundException;
import model.Livro;

public class LivroRepository extends BaseRepository<Livro> {

	private static final String fileName = "Livros.txt";
	private static LivroRepository instance;

	private LivroRepository() throws IOException, FileNotFoundException {
		super(fileName);
	}

	public LivroRepository instance() throws IOException, FileNotFoundException {
		if(instance == null)
			instance = new LivroRepository();
		return instance;
	}

	@Override
	public Livro getById(int id) throws IOException, FileNotFoundException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Livro> get() throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livro insert(Livro model) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void insertAll(ArrayList<Livro> list) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Livro update(Livro model) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) throws IOException {
		// TODO Auto-generated method stub

	}
}
