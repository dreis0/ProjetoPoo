package model;

public class Externo extends UsuarioComum {

	protected String RG;
	protected String endereco;
	
	public Externo() {
		super(TipoDeUsuario.externo);
	}
	
	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


}
