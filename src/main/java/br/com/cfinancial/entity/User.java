package br.com.cfinancial.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "cf_usuario_login")
	private String login;
	
	@Column(name = "cf_usuario_nome")
	private String nome;
	
	@Column(name = "cf_usuario_senha")
	private String senha;
	
	@Column(name = "cf_usuario_tipo")
	private String tipo;
	
	@Column(name = "cf_usuario_dtinclusao")
	private Date dt_inclusao;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDt_inclusao() {
		return dt_inclusao;
	}

	public void setDt_inclusao(Date dt_inclusao) {
		this.dt_inclusao = dt_inclusao;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", nome=" + nome + ", tipo=" + tipo + "]";
	}
	

}
