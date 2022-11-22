package br.edu.ifba.BackGincana.model;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "tb_usuario_evento")
public class Usuario_EventoModel {

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Usuario")
	private UsuarioModel id_Usuario;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Gincana")
	private UsuarioModel id_Gincana;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Evento")
	private EventoModel id_Evento;

	public Usuario_EventoModel() {
		super();
	}

	public Usuario_EventoModel(UsuarioModel id_Usuario, UsuarioModel id_Gincana, EventoModel id_Evento) {
		super();
		this.id_Usuario = id_Usuario;
		this.id_Gincana = id_Gincana;
		this.id_Evento = id_Evento;
	}

	public UsuarioModel getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(UsuarioModel id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public UsuarioModel getId_Gincana() {
		return id_Gincana;
	}

	public void setId_Gincana(UsuarioModel id_Gincana) {
		this.id_Gincana = id_Gincana;
	}

	public EventoModel getId_Evento() {
		return id_Evento;
	}

	public void setId_Evento(EventoModel id_Evento) {
		this.id_Evento = id_Evento;
	}

	
}
