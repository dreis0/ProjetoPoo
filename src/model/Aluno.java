package model;

public class Aluno extends UsuarioComum{

	public String RA;
	
	public Aluno(TipoDeUsuario tipo, String nome, String email, String senha) {
		super(TipoDeUsuario.aluno);
	}

	public String getRA() {
		return RA;
	}

	public void setRA(String rA) {
		RA = rA;
	}
}
