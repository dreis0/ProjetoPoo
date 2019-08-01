import model.Aluno;
import model.ExemplarDeLivro;
import model.Livro;
import model.Usuario;
import txtRepository.ExemplarDeLivroRepository;
import txtRepository.LivroRepository;
import txtRepository.UsuarioRepository;

public class Principal {

	public static void main(String[] args) {

		try (ExemplarDeLivroRepository repository = ExemplarDeLivroRepository.instance()) {
			ExemplarDeLivro exemplar = new ExemplarDeLivro();
			
			exemplar.setDisponivel(true);
			exemplar.setReservado(false);
			exemplar.setAnoDeLancamento(1900);
			exemplar.setEditora("Editora 2 ");
			exemplar.setLivroId(1);
			exemplar.setEdicao(15);
			
			repository.insert(exemplar);
			
			
			
		} catch (Exception e) {
			System.out.println("Exception em Principal: " + e);
		}
	}

}
