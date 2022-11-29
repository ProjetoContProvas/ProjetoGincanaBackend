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
	
	

}
