package br.edu.ifba.BackGincana.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable /*Esse anotation faz parte de uma configuração da tebela criterioModel, que usa identificadores primarios de outra duas tabelas*/
public class Nota_CriterioModelID implements Serializable {

	private Integer id_Criterio;
	private Integer id_Equipe;

	public Nota_CriterioModelID() {
		super();
	}

	public Nota_CriterioModelID(Integer id_Criterio, Integer id_Equipe) {
		super();
		this.id_Criterio = id_Criterio;
		this.id_Equipe = id_Equipe;
	}

	public Integer getId_Criterio() {
		return id_Criterio;
	}

	public void setId_Criterio(Integer id_Criterio) {
		this.id_Criterio = id_Criterio;
	}

	public Integer getId_Equipe() {
		return id_Equipe;
	}

	public void setId_Equipe(Integer id_Equipe) {
		this.id_Equipe = id_Equipe;
	}

	@Override
	public String toString() {
		return "NotaCriterioModelID [id_Criterio=" + id_Criterio + ", id_Equipe=" + id_Equipe + "]";
	}

}
