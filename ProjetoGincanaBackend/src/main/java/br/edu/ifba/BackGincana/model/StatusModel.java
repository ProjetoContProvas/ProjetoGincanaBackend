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


@Entity /*   Esse Anotation indica que essa classe representa uma entidade, ou seja, uma tabela do banco de dados   */
@Table(name = "tb_status")
public class StatusModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Status", nullable = false)
	private Integer id_Status;

	@Column(name = "situacao_Status", length = 12, nullable = false)
	private String situacao_Status;
	
	@OneToMany(mappedBy="status")
	private Set<GincanaModel> gincanas = new HashSet<GincanaModel>();

	@OneToMany(mappedBy = "status")
	private Set<EventoModel> eventos = new HashSet<EventoModel>();
	
	
	public StatusModel() {
		super();
	}


	public StatusModel(Integer id_Status, String situacao_Status) {
		super();
		this.id_Status = id_Status;
		this.situacao_Status = situacao_Status;
	}


	public Integer getId_Status() {
		return id_Status;
	}


	public void setId_status(Integer id_Status) {
		this.id_Status = id_Status;
	}


	public String getSituacao_Status() {
		return situacao_Status;
	}


	public void setSituacao_Status(String situacao_Status) {
		this.situacao_Status = situacao_Status;
	}


	@Override
	public String toString() {
		return "StatusModel [id_status=" + id_Status + ", situacao_Status=" + situacao_Status + "]";
	}

	

}
