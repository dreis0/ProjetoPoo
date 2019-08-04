package areas;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exceptions.NotFoundException;
import exceptions.UsuarioJaExisteException;
import interfaces.IMasterActions;
import model.Aluno;
import model.Bibliotecario;
import model.Externo;
import model.Professor;
import model.Usuario;

public class AreaDoMaster {

	private IMasterActions actions;

	public AreaDoMaster(IMasterActions actions) {
		this.actions = actions;
	}

	public void areaDoMaster() {
		String input = "";

		do {
			input = JOptionPane.showInputDialog("Digite: \n" + "1 - Para adicionar usu�rios \n"
					+ "2 - Para remover usu�rios \n" + "3 - Para ver os usu�rios \n" + "s - Para sair");

			switch (input) {
			case "1":
				adicionarUsuario();
				break;
			case "2":
				removerUsuario();
				break;
			case "3":
				verUsuarios();
			default:
				break;
			}
		} while (!input.equals("s") && !input.equals("S"));
	}

	private void adicionarUsuario() {
		try {

			String tipo = JOptionPane.showInputDialog("Digite o tipo do usu�rio: \n" + "1 - Para bibliotecario \n"
					+ "2 - Para aluno \n" + "3 - Para professor \n" + "4 - para usu�rio externo \n");
			String tipoDoc;
			Usuario usuario;

			switch (tipo) {
			case "1":
				usuario = new Bibliotecario();
				tipoDoc = "RG";
				break;
			case "2":
				usuario = new Aluno();
				tipoDoc = "RA";
				break;
			case "3":
				usuario = new Professor();
				tipoDoc = "RG";
				break;
			default:
				usuario = new Externo();
				tipoDoc = "RG";
				break;
			}

			usuario.setNome(JOptionPane.showInputDialog("Digite o nome do usu�rio: \n"));
			usuario.setEmail(JOptionPane.showInputDialog("Digite o email do usu�rio: \n"));
			usuario.setSenha(JOptionPane.showInputDialog("Digite a senha do usu�rio: \n"));
			usuario.setDocumento(JOptionPane.showInputDialog("Digite o " + tipoDoc + " do usu�rio"));

			actions.adicionarUsuario(usuario);

		} catch (UsuarioJaExisteException e) {
			JOptionPane.showInputDialog(e.getLocalizedMessage());
		} catch (Exception e) {
			JOptionPane.showInputDialog("N�o foi poss�vel adicionar o usu�rio");
		}
	}

	private void removerUsuario() {
		try {
			ArrayList<Usuario> usuarios = actions.getUsuarios();

			String lista = "";
			for (Usuario u : usuarios)
				if (u.getId() != 0)
					lista += u.toString();

			String id = JOptionPane.showInputDialog(lista + "Digite o id do usu�rio a ser removido \n");

			actions.removerUsuario(actions.getUsuario(Integer.parseInt(id)));

		} catch (NotFoundException notFound) {
			JOptionPane.showInputDialog(notFound.getLocalizedMessage());
		} catch (ParseException parseEx) {
			JOptionPane.showInputDialog("Id inv�lido");
		} catch (Exception e) {
			JOptionPane.showInputDialog("N�o foi poss�vel remover o usu�rio");
		}
	}

	private void verUsuarios() {
		try {
			ArrayList<Usuario> usuarios = actions.getUsuarios();

			String lista = "";
			for (Usuario u : usuarios)
				if (u.getId() != 0)
					lista += u.toString();

			JOptionPane.showInputDialog(lista);
		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro ao exibir lista");
		}

	}
}
