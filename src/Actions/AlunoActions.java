package Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.ParseException;

import exceptions.LimiteDeLivrosAtingidosException;
import exceptions.NaoPodeAlugarException;
import interfaces.IRepository;
import model.Emprestimo;
import model.ExemplarDeLivro;
import model.Livro;
import model.Usuario;

public class AlunoActions extends BaseUserActions {

	private final int diasDeEmprestimo = 30;
	private final int limiteDeLivros = 5;

	public AlunoActions(IRepository<Usuario> usuarioRepository, IRepository<Livro> livroRepository,
			IRepository<ExemplarDeLivro> exemplarRepository, IRepository<Emprestimo> emprestimoRepository) {
		super(usuarioRepository, livroRepository, exemplarRepository, emprestimoRepository);
	}

	@Override
	public Emprestimo alugar(Usuario usuario, ExemplarDeLivro exemplar)
			throws NaoPodeAlugarException, LimiteDeLivrosAtingidosException, FileNotFoundException, IOException, ParseException {

		if (usuario.getMultaAte().compareTo(Calendar.getInstance().getTime()) > 0)
			throw new NaoPodeAlugarException();
		if (obterLivrosEmprestados(usuario.getId()).toArray().length >= limiteDeLivros)
			throw new LimiteDeLivrosAtingidosException(limiteDeLivros);

		Emprestimo emprestimo = new Emprestimo();

		emprestimo.setUsuarioId(usuario.getId());
		emprestimo.setPrazoDeDevolucao(diasDeEmprestimo);
		emprestimo.setExemplarId(exemplar.getId());
		emprestimo.setDataDeEmprestimo(Calendar.getInstance().getTime());
		
		emprestimoRepository.insert(emprestimo);
		
		return emprestimo;
	}

	@Override
	public ArrayList<Emprestimo> obterLivrosEmprestados(int usuarioId) 
			throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
		ArrayList<Emprestimo> emprestimosExistentes = emprestimoRepository.get();
		ArrayList<Emprestimo> emprestimosDoUsuario = new ArrayList<Emprestimo>();
		
		for(Emprestimo e: emprestimosExistentes) 
			if(e.getUsuarioId() == usuarioId)
				if(e.getDataDeDevolucao().)
				
		return null;
	}

	@Override
	public void Devolver(Emprestimo emprestimo) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Emprestimo> consultaHistorico(int usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

}
