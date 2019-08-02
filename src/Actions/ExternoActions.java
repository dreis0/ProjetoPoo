package Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import exceptions.LimiteDeLivrosAtingidosException;
import exceptions.NaoPodeAlugarException;
import exceptions.NotFoundException;
import interfaces.IRepository;
import model.Emprestimo;
import model.ExemplarDeLivro;
import model.Livro;
import model.Usuario;

public class ExternoActions extends BaseUserActions {

	private final int diasDeEmprestimo = 30;
	private final int limiteDeLivros = 1;
	private final int diasDeMultaPorDiaDeAtraso = 20;

	public ExternoActions(IRepository<Usuario> usuarioRepository, IRepository<Livro> livroRepository,
			IRepository<ExemplarDeLivro> exemplarRepository, IRepository<Emprestimo> emprestimoRepository) {
		super(usuarioRepository, livroRepository, exemplarRepository, emprestimoRepository);
	}

	@Override
	public Emprestimo alugar(Usuario usuario, ExemplarDeLivro exemplar) throws NaoPodeAlugarException,
			LimiteDeLivrosAtingidosException, FileNotFoundException, IOException, ParseException {

		if (usuario.getMultaAte().isAfter(LocalDate.now()))
			throw new NaoPodeAlugarException();
		if (getLivrosEmprestados(usuario.getId()).toArray().length >= limiteDeLivros)
			throw new LimiteDeLivrosAtingidosException(limiteDeLivros);

		Emprestimo emprestimo = new Emprestimo();

		emprestimo.setUsuarioId(usuario.getId());
		emprestimo.setPrazoDeDevolucao(diasDeEmprestimo);
		emprestimo.setExemplarId(exemplar.getId());
		emprestimo.setDataDeEmprestimo(LocalDate.now());

		emprestimoRepository.insert(emprestimo);

		exemplar.setDisponivel(false);
		
		return emprestimo;
	}

	@Override
	public void Devolver(Emprestimo emprestimo)
			throws NotFoundException, FileNotFoundException, IOException, ParseException {
		if (emprestimo.getDataDeEmprestimo().plusDays(diasDeEmprestimo).isAfter(LocalDate.now())) {

			Usuario externo = usuarioRepository.getById(emprestimo.getUsuarioId());

			int diasDeMulta = (int) ChronoUnit.DAYS.between(emprestimo.getDataDeEmprestimo().plusDays(diasDeEmprestimo),
					LocalDate.now());
			externo.setMultaAte(LocalDate.now().plusDays(diasDeMulta * diasDeMultaPorDiaDeAtraso));
			usuarioRepository.update(externo);
		}

		emprestimo.setDataDaDevolucao(LocalDate.now());

		emprestimoRepository.update(emprestimo);

		ExemplarDeLivro exemplar = exemplaresRepository.getById(emprestimo.getExemplarId());
		exemplar.setDisponivel(true);
		exemplaresRepository.update(exemplar);
	}

}
