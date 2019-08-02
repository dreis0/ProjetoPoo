package Actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

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
	public ArrayList<Livro> getLivrosDisponiveis() throws IOException, FileNotFoundException, ParseException {
		ArrayList<Livro> livros = livrosRepository.get();
		ArrayList<ExemplarDeLivro> exemplares = exemplaresRepository.get();

		for (ExemplarDeLivro e : exemplares)
			if (e.isDisponivel())
				for (Livro l : livros)
					if (l.getId() == e.getId())
						l.addExemplar(e);

		ArrayList<Livro> disponiveis = new ArrayList<Livro>();

		for (Livro l : livros)
			if (l.getExemplares().toArray().length > 0)
				disponiveis.add(l);

		return disponiveis;
	}

}
