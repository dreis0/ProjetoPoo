package interfaces;

import java.util.ArrayList;

import model.Emprestimo;
import model.ExemplarDeLivro;

public interface IUserActions {
	
	public boolean podeAlugar();
	
	public Emprestimo alugar(ExemplarDeLivro exemplar);

	public void Devolver(int emprestimoId);
	
	public ArrayList<Emprestimo> consultaHistorico(int usuarioId);
}
