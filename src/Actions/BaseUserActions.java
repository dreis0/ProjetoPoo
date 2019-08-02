package Actions;

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
}
