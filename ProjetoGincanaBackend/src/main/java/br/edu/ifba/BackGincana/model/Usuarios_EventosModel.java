package br.edu.ifba.BackGincana.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
@IdClass(Usuario_EventoModelID.class)
public class Usuarios_EventosModel {


	@Id
	@ManyToOne
	@JoinColumn(name = "id_Evento")
	private EventoModel id_Evento;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "id_Usuario")
	private UsuarioModel id_Usuario;
	
	

	public Usuarios_EventosModel() {
		super();
	}



	public Usuarios_EventosModel(EventoModel id_Evento, UsuarioModel id_Usuario) {
		super();
		this.id_Evento = id_Evento;
		this.id_Usuario = id_Usuario;
	}

	
	
	
	
	
}
