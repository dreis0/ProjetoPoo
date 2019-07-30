package txtRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.NotFoundException;
import interfaces.ITxtRepository;
import model.Emprestimo;

public class EmprestimoRepository extends BaseRepository<Emprestimo> {

	private static final String fileName = "Emprestimos.txt";
	private static EmprestimoRepository instance;
	
	private EmprestimoRepository() throws FileNotFoundException, IOException {
		super(fileName);
	}
	
	public static EmprestimoRepository instance() throws FileNotFoundException, IOException {
		if(instance == null)
			instance = new EmprestimoRepository();
		return instance;
	}

	@Override
	public Emprestimo getById(int id) throws IOException, FileNotFoundException, NotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Emprestimo> get() throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emprestimo insert(Emprestimo model) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected void insertAll(ArrayList<Emprestimo> list) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Emprestimo update(Emprestimo model) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void close() throws Exception {
		super.close();
		instance = null;
	}

}
