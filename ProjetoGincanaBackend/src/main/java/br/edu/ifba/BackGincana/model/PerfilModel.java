package br.edu.ifba.BackGincana.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_perfil")
public class PerfilModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_perfil", nullable = false)
	private Integer id_perfil;

	@Column(name = "cargo_Perfil", length = 15, nullable = false)
	private String cargo_Perfil;

	
	
	public PerfilModel() {
		super();
	}

	
	public PerfilModel(Integer id_perfil, String cargo_Perfil) {
		super();
		this.id_perfil = id_perfil;
		this.cargo_Perfil = cargo_Perfil;
	}

	public Integer getId_perfil() {
		return id_perfil;
	}

	public void setId_perfil(Integer id_perfil) {
		this.id_perfil = id_perfil;
	}

	public String getCargo_Perfil() {
		return cargo_Perfil;
	}

	public void setCargo_Perfil(String cargo_Perfil) {
		this.cargo_Perfil = cargo_Perfil;
	}

}
