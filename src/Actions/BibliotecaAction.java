package actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import exceptions.NenhumItemException;
import exceptions.NotFoundException;
import interfaces.IBibliotecaActions;
import interfaces.IRepository;
import model.ExemplarDeLivro;
import model.Livro;

public class BibliotecaAction implements IBibliotecaActions {

	private IRepository<ExemplarDeLivro> exemplaresRepository;
	private IRepository<Livro> livrosRepository;

	public BibliotecaAction(IRepository<ExemplarDeLivro> exemplaresRepository, IRepository<Livro> livrosRepository) {
		this.exemplaresRepository = exemplaresRepository;
		this.livrosRepository = livrosRepository;
	}

	@Override
	public ExemplarDeLivro getExemplarById(int id)
			throws FileNotFoundException, IOException, NotFoundException, ParseException {
		return exemplaresRepository.getById(id);
	}

	@Override
	public Livro getlivroById(int id) throws FileNotFoundException, IOException, NotFoundException, ParseException {
		return livrosRepository.getById(id);
	}

	@Override
	public ArrayList<Livro> getLivrosDisponiveis()
			throws IOException, FileNotFoundException, ParseException, NenhumItemException {
		ArrayList<Livro> livros = livrosRepository.get();
		ArrayList<ExemplarDeLivro> exemplares = exemplaresRepository.get();

		for (Livro l : livros)
			for (ExemplarDeLivro e : exemplares)
				if (e.isDisponivel())
					if (l.getId() == e.getLivroId())
						l.addExemplar(e);

		ArrayList<Livro> disponiveis = new ArrayList<Livro>();

		for (Livro l : livros)
			if (l.getExemplares().toArray().length > 0)
				disponiveis.add(l);

		if (disponiveis.toArray().length == 0)
			throw new NenhumItemException("livro");

		return disponiveis;
	}

	@Override
	public ArrayList<Livro> getLivros() throws FileNotFoundException, IOException, ParseException, NenhumItemException {
		ArrayList<Livro> livros = livrosRepository.get();
		ArrayList<ExemplarDeLivro> exemplares = exemplaresRepository.get();

		for (Livro l : livros)
			for (ExemplarDeLivro e : exemplares)
				if (l.getId() == e.getLivroId())
					l.addExemplar(e);

		if (livros.toArray().length == 0)
			throw new NenhumItemException("livro");

		return livros;
	}

	@Override
	public void close() throws Exception {
		exemplaresRepository.close();
		livrosRepository.close();
	}

}
