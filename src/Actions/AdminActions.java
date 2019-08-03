package actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import exceptions.NotFoundException;
import interfaces.IRepository;
import interfaces.IBibliotecarioActions;
import model.Emprestimo;
import model.ExemplarDeLivro;
import model.Livro;

public class AdminActions implements IBibliotecarioActions {

	private IRepository<ExemplarDeLivro> exemplaresRepository;
	private IRepository<Livro> livroRepository;

	public AdminActions(IRepository<Livro> livroRepository, IRepository<ExemplarDeLivro> exemplarRepository) {

		this.livroRepository = livroRepository;
		this.exemplaresRepository = exemplarRepository;
	}

	@Override
	public void cadastrarLivro(Livro livro) throws FileNotFoundException, IOException {
		livroRepository.insert(livro);
	}

	@Override
	public void cadastrarExemplar(ExemplarDeLivro exemplar) throws FileNotFoundException, IOException {
		exemplaresRepository.insert(exemplar);
	}

	@Override
	public void removerLivro(Livro livro) throws NotFoundException, IOException, ParseException {
		livroRepository.deleteById(livro.getId());
	}

	@Override
	public void removerExemplar(ExemplarDeLivro exemplar) throws NotFoundException, IOException, ParseException {
		exemplaresRepository.deleteById(exemplar.getId());
	}

}
