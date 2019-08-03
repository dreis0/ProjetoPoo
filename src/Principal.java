import model.Aluno;
import model.Usuario;
import txtRepository.UsuarioRepository;

public class Principal {

	public static void main(String[] args) {
		try (UsuarioRepository repository = UsuarioRepository.instance()) {
			Usuario a = new Aluno();
			
//			switch
//				normal ->  classe telas de usuario normal -> na classe instancia o action
//				
			
			a.setNome("Miguel");
			a.setSenha("1234");
			a.setDocumento("11201721111");

			repository.insert(a);

		} catch (Exception e) {
			System.out.println("Exception em Principal: " + e);
		}
	}

}
