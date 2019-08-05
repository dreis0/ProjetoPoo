package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import exceptions.NotFoundException;
import exceptions.UsuarioJaExisteException;
import model.Usuario;

public interface IMasterActions extends AutoCloseable {

	public Usuario getUsuario(int id) throws FileNotFoundException, IOException, NotFoundException, ParseException;

	public ArrayList<Usuario> getUsuarios() throws IOException, ParseException;

	public void removerUsuario(Usuario usuario) throws IOException, ParseException;

	public void adicionarUsuario(Usuario usuario)
			throws IOException, ParseException, FileNotFoundException, UsuarioJaExisteException;
}