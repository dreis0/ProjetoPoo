package areas;

import java.io.FileNotFoundException;
import java.io.IOException;

import factory.ActionsFactory;
import model.Usuario;

public class Resolver {

	public static void Resolve(Usuario usuario) throws FileNotFoundException, IOException {

		switch (usuario.getTipo()) {
		case master:
			AreaDoMaster areaDoMaster = new AreaDoMaster(ActionsFactory.instance().getMasterActions());
			areaDoMaster.areaDoMaster();
			break;
		case bibliotecario:
			AreaDoBibliotecario areaDoBibliotecario = new AreaDoBibliotecario(
					ActionsFactory.instance().getBibliotecarioActions(),
					ActionsFactory.instance().getBibliotecaActions());
			areaDoBibliotecario.areaDoBibliotecario();
			break;
		default:
			AreaDoUsuario areaDoUsuario = new AreaDoUsuario(ActionsFactory.instance().resolveUserActions(usuario),
					ActionsFactory.instance().getBibliotecaActions());
			areaDoUsuario.areaDoUsuario();
			break;
		}
	}
}
