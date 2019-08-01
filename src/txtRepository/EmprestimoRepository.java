package txtRepository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import model.Emprestimo;

public class EmprestimoRepository extends BaseRepository<Emprestimo> {

	private static EmprestimoRepository instance;
	
	private EmprestimoRepository() throws FileNotFoundException, IOException {
		super("Emprestimos.txt");
	}
	
	public static EmprestimoRepository instance() throws FileNotFoundException, IOException {
		if(instance == null)
			instance = new EmprestimoRepository();
		return instance;
	}

	@Override
	protected int id() throws IOException, FileNotFoundException {
		return Utils.getNextId(fileName);
	}
	
	@Override
	protected String mapToFieldsString(Emprestimo model) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected Emprestimo mapToModel(String fieldsString) throws IOException, FileNotFoundException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void close() throws Exception {
		super.close();
		instance = null;
	}


}
