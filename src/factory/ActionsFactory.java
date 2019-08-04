package factory;

import java.io.FileNotFoundException;
import java.io.IOException;

import actions.AlunoActions;
import actions.BibliotecaAction;
import actions.BibliotecarioActions;
import actions.ExternoActions;
import actions.LoginActions;
import actions.MasterActions;
import actions.ProfessorActions;
import interfaces.IBibliotecaActions;
import interfaces.IBibliotecarioActions;
import interfaces.ILogin;
import interfaces.IMasterActions;
import interfaces.IUserActions;
import model.Usuario;

public class ActionsFactory {

	private static ActionsFactory instance;

	private ActionsFactory() {
	}

	public static ActionsFactory instance() {
		if (instance == null)
			instance = new ActionsFactory();
		return instance;
	}

	public ILogin getLoginActions() throws FileNotFoundException, IOException {
		return new LoginActions(this.getAlunoActions());
	}

	public IUserActions resolveUserActions(Usuario usuario) throws FileNotFoundException, IOException {
		
		switch (usuario.getTipo()) {
		case aluno:
			return getAlunoActions();
		case professor:
			return getProfessorActions();
		default: 
			return getExternoActions();
		}
	}

	public IUserActions getAlunoActions() throws FileNotFoundException, IOException {
		return new AlunoActions(RepositoryFactory.instance().getUsuarioRepository(),
				RepositoryFactory.instance().getLivroRepository(),
				RepositoryFactory.instance().getExemplarDeLivroRepository(),
				RepositoryFactory.instance().getEmprestimoRepository());
	}

	public IUserActions getProfessorActions() throws FileNotFoundException, IOException {
		return new ProfessorActions(RepositoryFactory.instance().getUsuarioRepository(),
				RepositoryFactory.instance().getLivroRepository(),
				RepositoryFactory.instance().getExemplarDeLivroRepository(),
				RepositoryFactory.instance().getEmprestimoRepository());
	}

	public IUserActions getExternoActions() throws FileNotFoundException, IOException {
		return new ExternoActions(RepositoryFactory.instance().getUsuarioRepository(),
				RepositoryFactory.instance().getLivroRepository(),
				RepositoryFactory.instance().getExemplarDeLivroRepository(),
				RepositoryFactory.instance().getEmprestimoRepository());
	}

	public IBibliotecarioActions getBibliotecarioActions() throws FileNotFoundException, IOException {
		return new BibliotecarioActions(RepositoryFactory.instance().getLivroRepository(),
				RepositoryFactory.instance().getExemplarDeLivroRepository());
	}

	public IMasterActions getMasterActions() throws FileNotFoundException, IOException {
		return new MasterActions(RepositoryFactory.instance().getUsuarioRepository());
	}

	public IBibliotecaActions getBibliotecaActions() throws FileNotFoundException, IOException {
		return new BibliotecaAction(RepositoryFactory.instance().getExemplarDeLivroRepository(),
				RepositoryFactory.instance().getLivroRepository());
	}
}
