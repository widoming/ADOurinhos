package br.com.cfinancial.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Escala")
public class Schedule {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "cf_escala_mes")
	private int mes;
	
	@Column(name = "cf_escala_ano")
	private int ano;
	
	@Column(name = "cf_escala_avisos")
	private String aviso;
	
	@Column(name = "cf_escala_evento_id")
	private int evento_id;
	
	@Column(name = "cf_escala_dtinclusao")
	private Date dtinclusao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getAviso() {
		return aviso;
	}

	public void setAviso(String aviso) {
		this.aviso = aviso;
	}

	public int getEvento_id() {
		return evento_id;
	}

	public void setEvento_id(int evento_id) {
		this.evento_id = evento_id;
	}

	public Date getDtinclusao() {
		return dtinclusao;
	}

	public void setDtinclusao(Date dtinclusao) {
		this.dtinclusao = dtinclusao;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", mes=" + mes + ", ano=" + ano + ", aviso=" + aviso + ", evento_id=" + evento_id
				+ "]";
	}

}

