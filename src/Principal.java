import model.Aluno;
import txtRepository.UsuarioRepository;

public class Principal {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();

		aluno.setDocumento("11201721123");
		aluno.setEmail("email@email.com");
		aluno.setNome("Nome");
		aluno.setSenha("123");

		try (UsuarioRepository repository = UsuarioRepository.instance()) {
			//repository.insert(aluno);
			
			repository.deleteById(7);
		} catch (Exception e) {
			System.out.println("Exception em Principal: " + e);
		}
	}

}
