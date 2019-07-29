import model.Aluno;
import txtRepository.UsuarioRepository;

public class Principal {

	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		
		aluno.setDocumento("11201721123");
		aluno.setEmail("email@email.com");
		aluno.setNome("Nome");
		aluno.setSenha("123");

		UsuarioRepository repository = new UsuarioRepository();
		try {
			repository.insert(aluno);			
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
