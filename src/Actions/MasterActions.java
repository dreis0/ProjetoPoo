package actions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import exceptions.UsuarioJaExisteException;
import interfaces.IMasterActions;
import interfaces.IRepository;
import model.Usuario;

public class MasterActions implements IMasterActions {

	protected IRepository<Usuario> usuarioRepository;

	public MasterActions(IRepository<Usuario> usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public void removerUsuario(Usuario usuario) throws IOException, ParseException {
		usuarioRepository.deleteById(usuario.getId());
	}

	@Override
	public void adicionarUsuario(Usuario usuario)
			throws IOException, FileNotFoundException, UsuarioJaExisteException, ParseException {
		if (verificaSeEmailExiste(usuario))
			throw new UsuarioJaExisteException(usuario.getEmail());
		usuarioRepository.insert(usuario);
	}

	private boolean verificaSeEmailExiste(Usuario usuario) throws IOException, FileNotFoundException, ParseException {
		for (Usuario u : usuarioRepository.get()) {
			if (usuario.getEmail() == u.getEmail())
				return true;
		}
		return false;
	}

	@Override
	public void close() throws Exception {
		usuarioRepository.close();
	}
}