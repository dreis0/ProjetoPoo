package factory;

import java.io.FileNotFoundException;
import java.io.IOException;

import interfaces.IRepository;
import interfaces.IRepositoryFactory;
import model.Emprestimo;
import model.ExemplarDeLivro;
import model.Livro;
import model.Usuario;
import txtRepository.EmprestimoRepository;
import txtRepository.ExemplarDeLivroRepository;
import txtRepository.LivroRepository;
import txtRepository.UsuarioRepository;

public class RepositoryFactory<T> implements IRepositoryFactory {

	public  IRepository<Usuario> getUsuarioRepository() throws IOException, FileNotFoundException {
		return UsuarioRepository.instance();
	}

	public IRepository<Livro> getLivroRepository() throws IOException, FileNotFoundException {
		return LivroRepository.instance();
	}

	public IRepository<Emprestimo> getEmprestimoRepository() throws IOException, FileNotFoundException {
		return EmprestimoRepository.instance();
	}

	public IRepository<ExemplarDeLivro> getExemplarDeLivroRepository() throws IOException, FileNotFoundException {
		return ExemplarDeLivroRepository.instance();
	}
}
