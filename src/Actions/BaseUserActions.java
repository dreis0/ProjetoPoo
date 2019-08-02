package Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import interfaces.IRepository;
import interfaces.IUserActions;
import model.Emprestimo;
import model.ExemplarDeLivro;
import model.Livro;
import model.Usuario;

public abstract class BaseUserActions implements IUserActions {

	protected IRepository<Usuario> usuarioRepository;
	protected IRepository<Livro> livroRepository;
	protected IRepository<ExemplarDeLivro> exemplaresRepository;
	protected IRepository<Emprestimo> emprestimoRepository;

	public BaseUserActions(IRepository<Usuario> usuarioRepository, IRepository<Livro> livroRepository,
			IRepository<ExemplarDeLivro> exemplarRepository, IRepository<Emprestimo> emprestimoRepository) {
		this.usuarioRepository = usuarioRepository;
		this.livroRepository = livroRepository;
		this.exemplaresRepository = exemplarRepository;
		this.emprestimoRepository = emprestimoRepository;
	}
	
	@Override
	public ArrayList<Emprestimo> consultaHistorico(int usuarioId) 
			throws FileNotFoundException, IOException, ParseException {
		ArrayList<Emprestimo> emprestimosExistentes = emprestimoRepository.get();
		ArrayList<Emprestimo> emprestimosDoUsuario = new ArrayList<Emprestimo>();
		
		for(Emprestimo e: emprestimosExistentes) 
			if(e.getUsuarioId() == usuarioId)
				emprestimosDoUsuario.add(e);
		
		return emprestimosDoUsuario;
	}
	
	@Override
	public ArrayList<Emprestimo> obterLivrosEmprestados(int usuarioId) 
			throws FileNotFoundException, IOException, ParseException {
		ArrayList<Emprestimo> emprestimosExistentes = emprestimoRepository.get();
		ArrayList<Emprestimo> emprestimosDoUsuario = new ArrayList<Emprestimo>();
		
		for(Emprestimo e: emprestimosExistentes) 
			if(e.getUsuarioId() == usuarioId)
				if(e.getDataDeDevolucao().)
				
		return null;
	}
}
