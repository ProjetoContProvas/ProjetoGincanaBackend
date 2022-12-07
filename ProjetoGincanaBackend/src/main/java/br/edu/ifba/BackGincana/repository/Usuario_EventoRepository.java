package br.edu.ifba.BackGincana.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifba.BackGincana.model.Usuario_EventoModel;
import br.edu.ifba.BackGincana.model.Usuario_EventoModelID;

public interface Usuario_EventoRepository extends JpaRepository<Usuario_EventoModel, Usuario_EventoModelID>{
	
	

}
