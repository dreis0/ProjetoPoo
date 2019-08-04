package actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotActiveException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.NotFoundException;
import interfaces.IRepository;
import interfaces.IUserActions;
import model.Emprestimo;
import model.ExemplarDeLivro;
import model.Livro;
import model.Usuario;
import utils.DateUtils;

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
	public Usuario getByEmail(String email)
			throws FileNotFoundException, IOException, ParseException, ParseException, NotFoundException {
		ArrayList<Usuario> usuarios = usuarioRepository.get();

		for (Usuario u : usuarios) {
			if (u.getEmail().equals(email))
				return u;
		}

		throw new NotFoundException("Usuário");
	}

	@Override
	public ArrayList<Emprestimo> consultaHistorico(int usuarioId)
			throws FileNotFoundException, IOException, ParseException {
		ArrayList<Emprestimo> emprestimosExistentes = emprestimoRepository.get();
		ArrayList<Emprestimo> emprestimosDoUsuario = new ArrayList<Emprestimo>();

		for (Emprestimo e : emprestimosExistentes)
			if (e.getUsuarioId() == usuarioId)
				emprestimosDoUsuario.add(e);

		return emprestimosDoUsuario;
	}

	@Override
	public ArrayList<Emprestimo> getLivrosEmprestados(int usuarioId)
			throws FileNotFoundException, IOException, ParseException {
		ArrayList<Emprestimo> emprestimosExistentes = emprestimoRepository.get();
		ArrayList<Emprestimo> emprestimosDoUsuario = new ArrayList<Emprestimo>();

		for (Emprestimo e : emprestimosExistentes)
			if (e.getUsuarioId() == usuarioId)
				if (!e.getDataDaDevolucao().isAfter(DateUtils.minDate()))
					emprestimosDoUsuario.add(e);

		return emprestimosDoUsuario;
	}

	@Override
	public void close() throws Exception {
		usuarioRepository.close();
		exemplaresRepository.close();
		emprestimoRepository.close();
		livroRepository.close();
	}
}
