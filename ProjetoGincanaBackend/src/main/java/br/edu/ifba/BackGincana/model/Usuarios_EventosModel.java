package br.edu.ifba.BackGincana.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(Usuario_EventoModelID.class)
public class Usuarios_EventosModel {
	

	@Id
	@ManyToOne
	@JoinColumn(name = "id_Evento")
	private Integer id_Evento;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "id_Usuario")
	private Integer id_Usuario;
	
	

	public Usuarios_EventosModel() {
		super();
	}

	public Usuarios_EventosModel(Integer id_Evento, Integer id_Usuario) {
		super();
		this.id_Evento = id_Evento;
		this.id_Usuario = id_Usuario;
	}

	public Integer getId_Evento() {
		return id_Evento;
	}

	public void setId_Evento(Integer id_Evento) {
		this.id_Evento = id_Evento;
	}

	public Integer getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(Integer id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	@Override
	public String toString() {
		return "Usuarios_EventosModel [id_Evento=" + id_Evento + ", id_Usuario=" + id_Usuario + "]";
	}
	
	
	
	
}
