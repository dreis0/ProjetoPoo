package txtRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.ITxtRepository;
import model.Emprestimo;

public class EmprestimoRepository extends BaseRepository implements ITxtRepository<Emprestimo> {

	private static final String fileName = "Emprestimos.txt";
	
	private EmprestimoRepository() throws FileNotFoundException, IOException {
		super(fileName);
	}
	
	@Override
	public Emprestimo getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Emprestimo> get() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emprestimo insert(Emprestimo model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emprestimo update(Emprestimo model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

}
