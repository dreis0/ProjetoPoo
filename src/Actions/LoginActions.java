package actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import exceptions.AutenticacaoInvalidaException;
import exceptions.NotFoundException;
import interfaces.ILogin;
import interfaces.IUserActions;
import model.Usuario;

public class LoginActions implements ILogin {

	private IUserActions userActions;

	public LoginActions(IUserActions userActions) {
		this.userActions = userActions;
	}

	@Override
	public Usuario login(String email, String senha)
			throws AutenticacaoInvalidaException, FileNotFoundException, IOException, ParseException {

		try {
			Usuario usuario = userActions.getByEmail(email);

			if (!usuario.getSenha().equals(senha))
				throw new AutenticacaoInvalidaException();
			return usuario;

		} catch (NotFoundException e) {
			throw new AutenticacaoInvalidaException();
		}
	}

	@Override
	public void close() throws Exception {
		userActions.close();
	}

}
