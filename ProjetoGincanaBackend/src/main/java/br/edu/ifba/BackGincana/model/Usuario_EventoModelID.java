package br.edu.ifba.BackGincana.model;

import javax.persistence.Embeddable;

@Embeddable
public class Usuario_EventoModelID {
	
	private Integer id_Evento;
	
	private Integer id_Usuario;

	public Usuario_EventoModelID() {
		super();
	}

	public Usuario_EventoModelID(Integer id_Evento, Integer id_Usuario) {
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
		return "Usuario_EventoModelID [id_Evento=" + id_Evento + ", id_Usuario=" + id_Usuario + "]";
	}
	
	

}
