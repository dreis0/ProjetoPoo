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

			Aluno aluno2 = new Aluno();
			aluno2 = (Aluno) repository.getById(1);
			aluno2.setNome("Outro");
			repository.update(aluno2);

			// repository.deleteById(2);
			// repository.insert(aluno);

		} catch (Exception e) {
			System.out.println("Exception em Principal: " + e);
		}
	}

}
