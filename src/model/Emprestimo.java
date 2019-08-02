package model;

import java.util.Calendar;
import java.util.Date;

public class Emprestimo extends Queryable {

	protected int usuarioId;

	protected int exemplarId;

	protected Date dataDeEmprestimo;

	protected int prazoDeDevolucao;

	protected Date dataDaDevolucao;

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public int getExemplarId() {
		return exemplarId;
	}

	public void setExemplarId(int exemplarId) {
		this.exemplarId = exemplarId;
	}

	public Date getDataDeEmprestimo() {
		return dataDeEmprestimo;
	}

	public void setDataDeEmprestimo(Date dataDeEmprestimo) {
		this.dataDeEmprestimo = dataDeEmprestimo;
	}

	public int getPrazoDeDevolucao() {
		return prazoDeDevolucao;
	}

	public void setPrazoDeDevolucao(int prazoDeDevolucao) {
		this.prazoDeDevolucao = prazoDeDevolucao;
	}

	public Date getDataDaDevolucao() {
		return dataDaDevolucao;
	}

	public void setDataDaDevolucao(Date dataDaDevolucao) {
		this.dataDaDevolucao = dataDaDevolucao;
	}
}
