package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.text.ParseException;


import exceptions.LimiteDeLivrosAtingidosException;
import exceptions.NaoPodeAlugarException;
import model.Emprestimo;
import model.ExemplarDeLivro;
import model.Usuario;

public interface IUserActions {

	public Emprestimo alugar(Usuario usuario, ExemplarDeLivro exemplar) throws NaoPodeAlugarException,
			LimiteDeLivrosAtingidosException, FileNotFoundException, IOException, ParseException;

	public void Devolver(Emprestimo emprestimo);

	public ArrayList<Emprestimo> obterLivrosEmprestados(int usuarioId)
			throws FileNotFoundException, IOException, ParseException;

	public ArrayList<Emprestimo> consultaHistorico(int usuarioId);
}
