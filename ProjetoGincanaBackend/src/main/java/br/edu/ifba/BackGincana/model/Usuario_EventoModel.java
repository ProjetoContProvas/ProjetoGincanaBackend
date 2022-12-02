package br.edu.ifba.BackGincana.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "tb_usuario_evento")
@IdClass(Usuario_EventoModelID.class)
public class Usuario_EventoModel {


	@Id
	@ManyToOne
	@JoinColumn(name = "id_Evento")
	private EventoModel id_Evento;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "id_Usuario")
	private UsuarioModel id_Usuario;
	
	

	public Usuario_EventoModel() {
		super();
	}



	public Usuario_EventoModel(EventoModel id_Evento, UsuarioModel id_Usuario) {
		super();
		this.id_Evento = id_Evento;
		this.id_Usuario = id_Usuario;
	}



	public EventoModel getId_Evento() {
		return id_Evento;
	}



	public void setId_Evento(EventoModel id_Evento) {
		this.id_Evento = id_Evento;
	}



	public UsuarioModel getId_Usuario() {
		return id_Usuario;
	}



	public void setId_Usuario(UsuarioModel id_Usuario) {
		this.id_Usuario = id_Usuario;
	}



	@Override
	public String toString() {
		return "Usuarios_EventosModel [id_Evento=" + id_Evento + ", id_Usuario=" + id_Usuario + "]";
	}

	
	
	
	
	
}
