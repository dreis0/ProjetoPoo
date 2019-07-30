package txtRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.NotFoundException;
import model.ExemplarDeLivro;

public class ExemplarDeLivroRepository extends BaseRepository<ExemplarDeLivro> {

	public static String fileName = "Exemplares.txt";
	private static ExemplarDeLivroRepository instance;
	
	private ExemplarDeLivroRepository() throws FileNotFoundException, IOException {
		super(fileName);
	}
	
	public static ExemplarDeLivroRepository instance() throws FileNotFoundException, IOException {
		if(instance == null)
			instance = new ExemplarDeLivroRepository();
		return instance;
	}
	
	@Override
	public ExemplarDeLivro getById(int id) throws IOException, FileNotFoundException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ExemplarDeLivro> get() throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExemplarDeLivro insert(ExemplarDeLivro model) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExemplarDeLivro update(ExemplarDeLivro model) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
