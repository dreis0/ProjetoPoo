package model;

import java.util.Date;

public abstract class UsuarioComum extends Usuario {

	protected Date multaAte;
	
	public UsuarioComum(TipoDeUsuario tipo) {
		super(tipo);
	}
	
}
