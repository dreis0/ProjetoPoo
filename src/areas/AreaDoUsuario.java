package areas;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import exceptions.LimiteDeLivrosAtingidosException;
import exceptions.NaoPodeAlugarException;
import exceptions.NotFoundException;
import interfaces.IBibliotecaActions;
import interfaces.IUserActions;
import jdk.nashorn.internal.runtime.ParserException;
import model.Emprestimo;
import model.ExemplarDeLivro;
import model.Livro;

public class AreaDoUsuario {

	private IUserActions actions;
	private IBibliotecaActions bibliotecaActions;

	public AreaDoUsuario(IUserActions actions, IBibliotecaActions bibliotecaActions) {
		this.actions = actions;
		this.bibliotecaActions = bibliotecaActions;
	}

	public void areaDoUsuario() {
		String input = "";

		do {
			input = JOptionPane.showInputDialog("Digite: \n" + "1 - Para consultar os livros \n"
					+ "2 - Para alugar um exemplar \n" + "3 - Para devolver um exemplar \n"
					+ "4 - Para consultar o histórico de empréstimos \n" + "s - Para sair");

			switch (input) {
			case "1":
				verLivros();
				break;
			case "2":
				alugarLivro();
				break;
			case "3":
				devolverLivro();
				break;
			case "4":
				verEmprestimos();
			default:
				break;
			}
		} while (!input.equals("s") && !input.equals("S"));
	}

	public void alugarLivro() {
		try {
			String lista = "";
			ArrayList<Livro> livros = bibliotecaActions.getLivrosDisponiveis();

			for (Livro l : livros) {
				lista += l.getTitulo() + ": \n";
				for (ExemplarDeLivro e : l.getExemplares())
					lista += "    - " + e.toString();
			}

			String id = JOptionPane.showInputDialog(lista + "\n Digite o id do exemplar escolhido: \n");

			ExemplarDeLivro exemplar = bibliotecaActions.getExemplarById(Integer.parseInt(id));

			actions.alugar(Context.getCurrentUser(), exemplar);

		} catch (NotFoundException notFoundEx) {
			JOptionPane.showInputDialog("Exemplar não encontrado a partir do id digitado");

		} catch (ParserException parseEx) {
			JOptionPane.showInputDialog("Id inválido");

		} catch (LimiteDeLivrosAtingidosException limitEx) {
			JOptionPane.showInputDialog("Limite de empréstimos atingidos");

		} catch (NaoPodeAlugarException multaEx) {
			JOptionPane.showInputDialog("Este usuário está bloqueado para empréstimos");

		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro ao realizar empréstimo");
		}
	}

	public void devolverLivro() {
		try {
			ArrayList<Emprestimo> emprestimos = actions.getLivrosEmprestados(Context.getCurrentUser().getId());
			if (emprestimos.toArray().length == 0) {
				JOptionPane.showInputDialog("Nenhum empréstimo registrado");
				return;
			}

			ArrayList<ExemplarDeLivro> exemplares = new ArrayList<ExemplarDeLivro>();
			ArrayList<Livro> livros = new ArrayList<Livro>();

			for (Emprestimo e : emprestimos) {
				exemplares.add(bibliotecaActions.getExemplarById(e.getExemplarId()));
			}

			for (ExemplarDeLivro e : exemplares) {
				e.setLivro(bibliotecaActions.getlivroById(e.getLivroId()));
				livros.add(bibliotecaActions.getlivroById(e.getLivroId()));
			}

			for (Livro l : livros)
				for (ExemplarDeLivro e : exemplares)
					if (e.getLivroId() == l.getId())
						l.addExemplar(e);

			String lista = "";
			for (Livro l : livros) {
				lista += l.getTitulo() + ": ";
				for (ExemplarDeLivro e : l.getExemplares())
					lista += e.toString() + " \n";
			}

			String id = JOptionPane.showInputDialog(lista + " \n" + "Digite o id do exemplar a ser devolvido: \n");

			Emprestimo devolucao = new Emprestimo();
			for (Emprestimo e : emprestimos) {
				if (e.getExemplarId() == Integer.parseInt(id))
					devolucao = e;
			}

			actions.devolver(devolucao);

		} catch (ParseException parseEx) {
			JOptionPane.showInputDialog("Id inválido");
		} catch (NotFoundException notFoundEx) {
			JOptionPane.showInputDialog(notFoundEx.getLocalizedMessage());
		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro ao devolver livro");
		}
	}

	public void verLivros() {
		try {
			ArrayList<Livro> livros = bibliotecaActions.getLivrosDisponiveis();

			String lista = "";
			for (Livro l : livros) {
				lista += l.toString() + ": \n";
				for (ExemplarDeLivro e : l.getExemplares())
					lista += "      " + e.toString();
			}

			if (lista.equals("")) {
				JOptionPane.showInputDialog("Não há livros para exibir");
				return;
			}

			JOptionPane.showInputDialog(lista);

		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro ao exibir lista");
		}
	}

	public void verEmprestimos() {
		try {
			ArrayList<Emprestimo> emprestimos = actions.consultaHistorico(Context.getCurrentUser().getId());
			ArrayList<ExemplarDeLivro> exemplares = new ArrayList<ExemplarDeLivro>();
			ArrayList<Livro> livros = new ArrayList<Livro>();

			for (Emprestimo e : emprestimos) {
				e.setExemplar(bibliotecaActions.getExemplarById(e.getExemplarId()));
			}

			for (Emprestimo e : emprestimos) {
				e.setLivro(bibliotecaActions.getlivroById(e.getExemplar().getLivroId()));
			}

			String lista = "";

			for(Emprestimo e : emprestimos) {
				lista += "Empréstimo em: " + e.getDataDeEmprestimo() + " - " + e.getLivro().getTitulo() 
						+ ", " + e.getLivro().getAutor() + " " + e.getExemplar().getEdicao() + "/n";
			}
			
			JOptionPane.showInputDialog(lista);
			
		} catch (Exception e) {
			JOptionPane.showInputDialog("Erro ao exibir lista");
		}
	}

}
