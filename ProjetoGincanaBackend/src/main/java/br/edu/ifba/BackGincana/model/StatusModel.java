package br.edu.ifba.BackGincana.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_status")
public class StatusModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_status", nullable = false)
	private Integer id_status;

	@Column(name = "situacao_Status", length = 12, nullable = false)
	private String situacao_Status;

	@OneToMany(mappedBy = "statusModel")
	private Set<GincanaModel> gincana = new HashSet<GincanaModel>();

	public StatusModel(Integer id_status, String situacao_Status, Set<GincanaModel> gincana) {
		super();
		this.id_status = id_status;
		this.situacao_Status = situacao_Status;
		this.gincana = gincana;
	}

	public StatusModel() {
		super();
	}

	public Set<GincanaModel> getGincana() {
		return gincana;
	}

	public void setGincana(Set<GincanaModel> gincana) {
		this.gincana = gincana;
	}

	public Integer getId_status() {
		return id_status;
	}

	public void setId_status(Integer id_status) {
		this.id_status = id_status;
	}

	public String getSituacao_Status() {
		return situacao_Status;
	}

	public void setSituacao_Status(String situacao_Status) {
		this.situacao_Status = situacao_Status;
	}

}
