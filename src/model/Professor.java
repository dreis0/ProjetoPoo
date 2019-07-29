package model;

public class Professor extends UsuarioComum {

	protected String RG;

	public Professor() {
		super(TipoDeUsuario.professor);
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

}
