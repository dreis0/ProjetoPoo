import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import areas.AreaDoBibliotecario;
import areas.AreaDoMaster;
import areas.AreaDoUsuario;
import exceptions.AutenticacaoInvalidaException;
import factory.ActionsFactory;
import factory.RepositoryFactory;
import interfaces.ILogin;
import interfaces.IRepository;
import interfaces.IUserActions;
import model.*;

public class Principal {

	public static void _main(String[] args) {
		try (IRepository<Usuario> login = RepositoryFactory.instance().getUsuarioRepository()) {

			Usuario u = new Master();

			u.setNome("Master");
			u.setDocumento("Admin do sistema");
			u.setSenha("master");
			u.setEmail("master");

			login.insert(u);

		} catch (Exception e) {
			System.out.println("Erro: " + e.getLocalizedMessage());
		}
	}

	public static void main(String[] args) {
		int tentativas = 0;
		while (tentativas < 5) {
			try (ILogin login = ActionsFactory.instance().getLoginActions()) {

				String email = JOptionPane.showInputDialog("Digite seu email \n");

				String senha = JOptionPane.showInputDialog("Digite sua senha \n");

				Context.setCurrentUser(login.login(email, senha));

				System.out.println(Context.getCurrentUser().getNome());

			} catch (AutenticacaoInvalidaException autException) {
				JOptionPane.showInputDialog(autException.getLocalizedMessage());
			} catch (IOException | ParseException e) {
				JOptionPane.showConfirmDialog(null, "Ocorreu um erro ao ler os arquivos, por favor refaça o login");
				tentativas = -1;
			} catch (Exception e) {
				JOptionPane.showInputDialog("Ocorreu um erro inesperado, o sistema irá encerrar automaticamente");
				System.out.println("Exception em Principal: " + e);
				break;
			}

			tentativas++;
		}
	}

	public static void areas(Usuario usuario) throws FileNotFoundException, IOException {

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
			AreaDoUsuario areaDoUsuario = new AreaDoUsuario(
					ActionsFactory.instance().resolveUserActions(Context.getCurrentUser()),
					ActionsFactory.instance().getBibliotecaActions());
			areaDoUsuario.areaDoUsuario();
			break;
		}
	}
}
