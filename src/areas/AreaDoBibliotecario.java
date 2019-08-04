package areas;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exceptions.LivroEmprestadoException;
import exceptions.NotFoundException;
import interfaces.IBibliotecaActions;
import interfaces.IBibliotecarioActions;
import model.ExemplarDeLivro;
import model.Livro;

public class AreaDoBibliotecario {

	private IBibliotecarioActions userActions;
	private IBibliotecaActions bibliotecaActions;

	public AreaDoBibliotecario(IBibliotecarioActions userActions, IBibliotecaActions bibliotecaActions) {
		this.bibliotecaActions = bibliotecaActions;
		this.userActions = userActions;
	}

	public void areaDoBibliotecario() {
		String input = "";

		do {
			input = JOptionPane.showInputDialog("Digite: \n" + "1 - Para ver os livros cadastrados \n"
					+ "2 - Para ver os livros disponíveis \n" + "3 - Para adicionar um livro \n"
					+ "4 - Para remover um livro \n" + "5 - Para adicionar um exemplar \n"
					+ "6 - para remover um exemplar \n" + "s - Para sair");

			switch (input) {
			case "1":
				verLivros();
				break;
			case "2":
				verLivrosDisponiveis();
				break;
			case "3":
				adicionarLivro();
				break;
			case "4":
				removerLivro();
				break;
			case "5":
				adicionarExemplar();
				break;
			case "6":
				removerExemplar();
			case "s":
			case "S":
				break;
			default:
				JOptionPane.showInputDialog("Opção inválida");
				break;
			}
		} while (!input.equals("s") && !input.equals("S"));
	}

	private void verLivros() {
		try {
			String lista = "";
			ArrayList<Livro> livros = bibliotecaActions.getLivros();

			if (livros.toArray().length == 0) {
				JOptionPane.showInputDialog("Nenhum livro cadastrado");
				return;
			}

			for (Livro l : livros)
				lista += l.toString();

			JOptionPane.showInputDialog(lista);

		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro ao exibir lista");
		}
	}

	private void verLivrosDisponiveis() {
		try {
			String lista = "";
			ArrayList<Livro> livros = bibliotecaActions.getLivrosDisponiveis();

			if (livros.toArray().length == 0) {
				JOptionPane.showInputDialog("Nenhum livro disponível");
				return;
			}

			for (Livro l : livros)
				lista += l.toString();

			JOptionPane.showInputDialog(lista);

		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro ao exibir lista");
		}
	}

	private void adicionarLivro() {
		try {
			Livro livro = new Livro();

			livro.setTitulo(JOptionPane.showInputDialog("Digite o título: \n"));
			livro.setAutor(JOptionPane.showInputDialog("Digite o nome do autor: \n"));

			userActions.cadastrarLivro(livro);
		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro ao cadastrar livro");
		}
	}

	private void removerLivro() {
		try {
			String lista = "";
			ArrayList<Livro> livros = bibliotecaActions.getLivros();

			for (Livro l : livros)
				lista += l.toString();

			String id = JOptionPane.showInputDialog(lista + "\n Digite o id do livro a ser excluído: \n");

			userActions.removerLivro(bibliotecaActions.getlivroById(Integer.parseInt(id)));

		} catch (NotFoundException notFoundEx) {
			JOptionPane.showInputDialog("Esse id não corresponde a nenhum livro");
		} catch (ParseException parseEx) {
			JOptionPane.showInputDialog("Id inválido");
		} catch (LivroEmprestadoException emprestadoEx) {
			JOptionPane.showInputDialog("Não é possível excluir um livro com exemplares emprestados");
		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro ao remover livro");
		}
	}

	private void adicionarExemplar() {
		try {
			String lista = "";
			ArrayList<Livro> livros = bibliotecaActions.getLivros();

			for (Livro l : livros)
				lista += l.toString();

			String id = JOptionPane.showInputDialog(lista + "\n Digite o id do livro correspondente: \n");
			bibliotecaActions.getlivroById(Integer.parseInt(id));

			ExemplarDeLivro ex = new ExemplarDeLivro();
			ex.setLivroId(Integer.parseInt(id));
			ex.setEditora(JOptionPane.showInputDialog("Digite o nome da editora: \n"));
			ex.setEdicao(Integer.parseInt(JOptionPane.showInputDialog("Digite o número da edição: \n")));
			ex.setAnoDeLancamento(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de lançamento: \n")));
			ex.setDisponivel(true);
			ex.setReservado(false);

			userActions.cadastrarExemplar(ex);

		} catch (ParseException parseEx) {
			JOptionPane.showInputDialog("Input inválido");
		} catch (NotFoundException notFoundEx) {
			JOptionPane.showInputDialog("Esse id não corresponde a nenhum livro");
		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro ao cadastrar exemplar");
		}
	}

	private void removerExemplar() {
		try {
			ArrayList<Livro> livros = bibliotecaActions.getLivros();

			String lista = "";
			for (Livro l : livros) {
				lista += l.getTitulo() + " - Exemplares: \n";
				for (ExemplarDeLivro e : l.getExemplares())
					lista += "    - " + e.toString();
			}

			String id = JOptionPane.showInputDialog(lista + " \nDigite o id do exemplar a ser deletado: \n");

			userActions.removerExemplar(bibliotecaActions.getExemplarById(Integer.parseInt(id)));

		} catch (ParseException parseEx) {
			JOptionPane.showInputDialog("Id iválido");
		} catch (LivroEmprestadoException emprestadoEx) {
			JOptionPane.showInputDialog("Não é possível remover um exemplar que está empresatado");
		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro ao remover livro");
		}
	}

}
