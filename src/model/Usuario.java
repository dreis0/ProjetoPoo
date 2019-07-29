package model;

import java.util.Date;

public abstract class Usuario {

	protected int id;

	protected TipoDeUsuario tipo;

	protected String nome;

	protected String email;

	protected String senha;

	protected String documento;

	protected Date multaAte;

	public Usuario(TipoDeUsuario tipo) {
		this.tipo = tipo;
	}

	public TipoDeUsuario getTipo() {
		return this.tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Date getMultaAte() {
		return multaAte;
	}

	public void setMultaAte(Date multaAte) {
		this.multaAte = multaAte;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

}
