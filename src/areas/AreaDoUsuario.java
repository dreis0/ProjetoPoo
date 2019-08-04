package areas;

import interfaces.IBibliotecaActions;
import interfaces.IUserActions;

public class AreaDoUsuario {

	private IUserActions actions;
	private IBibliotecaActions bibliotecaActions;

	public AreaDoUsuario(IUserActions actions, IBibliotecaActions bibliotecaActions) {
		this.actions = actions;
		this.bibliotecaActions = bibliotecaActions;
	}

	public void areaDoUsuario() {

	}

}
