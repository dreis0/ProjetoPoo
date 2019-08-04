package areas;

import interfaces.IBibliotecaActions;
import interfaces.IBibliotecarioActions;

public class AreaDoBibliotecario {

	private IBibliotecarioActions userActions;
	private IBibliotecaActions bibliotecaActions;

	public AreaDoBibliotecario(IBibliotecarioActions userActions, IBibliotecaActions bibliotecaActions) {
		this.bibliotecaActions = bibliotecaActions;
		this.userActions = userActions;
	}

	public void areaDoBibliotecario() {

	}
}
