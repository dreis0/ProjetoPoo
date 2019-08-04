package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import exceptions.UsuarioJaExisteException;
import model.Usuario;

public interface IMasterActions extends AutoCloseable {

	public void removerUsuario(Usuario usuario) throws IOException, ParseException;

	public void adicionarUsuario(Usuario usuario)
			throws IOException, ParseException, FileNotFoundException, UsuarioJaExisteException;
}