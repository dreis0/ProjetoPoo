package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import exceptions.AutenticacaoInvalidaException;
import model.Usuario;

public interface ILogin extends AutoCloseable {

	public Usuario login(String email, String senha)
			throws AutenticacaoInvalidaException, FileNotFoundException, IOException, ParseException;
}
