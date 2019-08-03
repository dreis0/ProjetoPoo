package actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import exceptions.ExemplarSemPaiException;
import exceptions.NotFoundException;
import interfaces.IBibliotecarioActions;
import interfaces.IRepository;
import model.ExemplarDeLivro;
import model.Livro;

public class BibliotecarioActions implements IBibliotecarioActions {

	private IRepository<Livro> livroRepository;
	private IRepository<ExemplarDeLivro> exemplarRepository;

	public BibliotecarioActions(IRepository<Livro> livroRepository, IRepository<ExemplarDeLivro> exemplarRepository) {
		this.exemplarRepository = exemplarRepository;
		this.livroRepository = livroRepository;
	}

	@Override
	public void cadastrarLivro(Livro livro) throws FileNotFoundException, IOException {
		livroRepository.insert(livro);
	}

	@Override
	public void cadastrarExemplar(ExemplarDeLivro exemplar)
			throws FileNotFoundException, IOException, ParseException, ExemplarSemPaiException {
		try {
			livroRepository.getById(exemplar.getLivroId());

		} catch (NotFoundException e) {
			throw new ExemplarSemPaiException();
		}

		exemplarRepository.insert(exemplar);
	}

	@Override
	public void removerExemplar(ExemplarDeLivro exemplar) throws NotFoundException, IOException, ParseException {
		exemplarRepository.deleteById(exemplar.getId());
	}

	@Override
	public void removerLivro(Livro livro) throws NotFoundException, IOException, ParseException {
		ArrayList<ExemplarDeLivro> exemplares = exemplarRepository.get();

		for (ExemplarDeLivro e : exemplares)
			if (e.getLivroId() == livro.getId())
				exemplarRepository.deleteById(e.getId());

		livroRepository.deleteById(livro.getId());
	}

}