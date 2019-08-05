package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.Emprestimo;
import model.ExemplarDeLivro;
import model.Livro;
import model.Usuario;
import txtRepository.EmprestimoRepository;
import txtRepository.ExemplarDeLivroRepository;
import txtRepository.LivroRepository;
import txtRepository.UsuarioRepository;

public interface IRepositoryFactory {

	public IRepository<Usuario> getUsuarioRepository() throws IOException, FileNotFoundException;

	public IRepository<Livro> getLivroRepository() throws IOException, FileNotFoundException;

	public IRepository<Emprestimo> getEmprestimoRepository() throws IOException, FileNotFoundException;

	public IRepository<ExemplarDeLivro> getExemplarDeLivroRepository() throws IOException, FileNotFoundException;
}
