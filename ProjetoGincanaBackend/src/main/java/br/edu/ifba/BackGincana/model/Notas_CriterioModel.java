package br.edu.ifba.BackGincana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_notas_criterio")
public class Notas_CriterioModel {
	@Id
	@Column(name = "nota_Criterio", nullable = false)
	private Integer nota_Criterio;

	@ManyToOne
	@JoinColumn(name = "id_criterio", nullable = false)
	private CriterioModel id_Criterio;

	@ManyToOne
	@JoinColumn(name = "id_Equipe", nullable = false)
	private EquipeModel id_Equipe;

	public Notas_CriterioModel() {
		super();
	}

	public Notas_CriterioModel(Integer nota_Criterio, CriterioModel id_Criterio, EquipeModel id_Equipe) {
		super();
		this.nota_Criterio = nota_Criterio;
		this.id_Criterio = id_Criterio;
		this.id_Equipe = id_Equipe;
	}

	public Integer getNota_Criterio() {
		return nota_Criterio;
	}

	public void setNota_Criterio(Integer nota_Criterio) {
		this.nota_Criterio = nota_Criterio;
	}

	public CriterioModel getId_Criterio() {
		return id_Criterio;
	}

	public void setId_criterio(CriterioModel id_Criterio) {
		this.id_Criterio = id_Criterio;
	}

	public EquipeModel getId_Equipe() {
		return id_Equipe;
	}

	public void setId_Equipe(EquipeModel id_Equipe) {
		this.id_Equipe = id_Equipe;
	}

	@Override
	public String toString() {
		return "Notas_CriterioModel [nota_Criterio=" + nota_Criterio + ", id_Criterio=" + id_Criterio + ", id_Equipe="
				+ id_Equipe + "]";
	}
	
	

}
