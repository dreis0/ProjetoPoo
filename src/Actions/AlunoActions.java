package Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.ParseException;
import java.time.LocalDate;

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
	public Emprestimo alugar(Usuario usuario, ExemplarDeLivro exemplar) throws NaoPodeAlugarException,
			LimiteDeLivrosAtingidosException, FileNotFoundException, IOException, ParseException {

		if (usuario.getMultaAte().isAfter(LocalDate.now()))
			throw new NaoPodeAlugarException();
		if (obterLivrosEmprestados(usuario.getId()).toArray().length >= limiteDeLivros)
			throw new LimiteDeLivrosAtingidosException(limiteDeLivros);

		Emprestimo emprestimo = new Emprestimo();

		emprestimo.setUsuarioId(usuario.getId());
		emprestimo.setPrazoDeDevolucao(diasDeEmprestimo);
		emprestimo.setExemplarId(exemplar.getId());
		emprestimo.setDataDeEmprestimo(LocalDate.now());

		emprestimoRepository.insert(emprestimo);

		return emprestimo;
	}

	@Override
	public void Devolver(Usuario usuario, Emprestimo emprestimo) {

	}
}
