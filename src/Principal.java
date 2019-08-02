import model.Aluno;
import model.ExemplarDeLivro;
import model.Livro;
import model.Usuario;
import txtRepository.ExemplarDeLivroRepository;
import txtRepository.LivroRepository;
import txtRepository.UsuarioRepository;

public class Principal {

	public static void main(String[] args) {

		try (UsuarioRepository repository = UsuarioRepository.instance()) {
			Usuario a = new Aluno();

			a.setNome("Miguel");
			a.setSenha("1234");
			a.setDocumento("11201721111");

			repository.insert(a);

		} catch (Exception e) {
			System.out.println("Exception em Principal: " + e);
		}
	}

}
