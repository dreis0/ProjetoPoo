package model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import utils.DateUtils;

public class Emprestimo extends Queryable {

	protected int usuarioId;

	protected int exemplarId;

	protected LocalDate dataDeEmprestimo = DateUtils.minDate();

	protected int prazoDeDevolucao;

	protected LocalDate dataDaDevolucao = DateUtils.minDate();

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

	public LocalDate getDataDeEmprestimo() {
		return dataDeEmprestimo;
	}

	public void setDataDeEmprestimo(LocalDate dataDeEmprestimo) {
		this.dataDeEmprestimo = dataDeEmprestimo;
	}

	public void setDataDeEmprestimo(String dataDeEmprestimo) {
		this.dataDeEmprestimo = LocalDate.parse(dataDeEmprestimo, DateUtils.FORMATO_PADRAO);
	}

	public int getPrazoDeDevolucao() {
		return prazoDeDevolucao;
	}

	public void setPrazoDeDevolucao(int prazoDeDevolucao) {
		this.prazoDeDevolucao = prazoDeDevolucao;
	}

	public LocalDate getDataDaDevolucao() {
		return dataDaDevolucao;
	}

	public void setDataDaDevolucao(LocalDate dataDaDevolucao) {
		this.dataDaDevolucao = dataDaDevolucao;
	}

	public void setDataDaDevolucao(String dataDaDevolucao) {
		this.dataDaDevolucao = LocalDate.parse(dataDaDevolucao, DateUtils.FORMATO_PADRAO);
	}
}
