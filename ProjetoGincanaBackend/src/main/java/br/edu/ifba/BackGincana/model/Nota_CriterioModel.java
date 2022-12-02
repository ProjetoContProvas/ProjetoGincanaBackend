package br.edu.ifba.BackGincana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_notas_criterio")
@IdClass(Nota_CriterioModelID.class)
public class Nota_CriterioModel {

	@Id
	@ManyToOne
	@JoinColumn(name = "id_Criterio")
	private CriterioModel id_Criterio;

	@Id
	@ManyToOne
	@JoinColumn(name = "id_Equipe")
	private EquipeModel id_Equipe;

	@Column(name = "nota_Criterios")
	private Integer nota_Criterios;

	public Nota_CriterioModel() {
		super();
	}

	public Nota_CriterioModel(CriterioModel id_Criterio, EquipeModel id_Equipe, Integer nota_Criterios) {
		super();
		this.id_Criterio = id_Criterio;
		this.id_Equipe = id_Equipe;
		this.nota_Criterios = nota_Criterios;
	}

	public CriterioModel getId_Criterio() {
		return id_Criterio;
	}

	public void setId_Criterio(CriterioModel id_Criterio) {
		this.id_Criterio = id_Criterio;
	}

	public EquipeModel getId_Equipe() {
		return id_Equipe;
	}

	public void setId_Equipe(EquipeModel id_Equipe) {
		this.id_Equipe = id_Equipe;
	}

	public Integer getNota_Criterios() {
		return nota_Criterios;
	}

	public void setNota_Criterios(Integer nota_Criterios) {
		this.nota_Criterios = nota_Criterios;
	}

	@Override
	public String toString() {
		return "Nota_CriterioModel [id_Criterio=" + id_Criterio + ", id_Equipe=" + id_Equipe + ", nota_Criterios="
				+ nota_Criterios + "]";
	}

}
