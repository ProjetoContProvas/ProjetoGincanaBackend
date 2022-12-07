package br.edu.ifba.BackGincana.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.BackGincana.model.UsuarioModel;
import br.edu.ifba.BackGincana.model.Usuario_EventoModel;
import br.edu.ifba.BackGincana.model.Usuario_EventoModelID;
import br.edu.ifba.BackGincana.repository.Usuario_EventoRepository;

@RestController
@RequestMapping("/usuario_evento")
public class Usuario_EventoController {
	
	@Autowired
	private Usuario_EventoRepository usuario_EventoRepository;
	
	
	@GetMapping("/listall")
	public List<Usuario_EventoModel> listall() {
		List<Usuario_EventoModel> result = usuario_EventoRepository.findAll();
		return result;
	}
	
	@GetMapping("/{id}")
	public Usuario_EventoModel findById(@PathVariable Usuario_EventoModelID id) {
		Optional<Usuario_EventoModel> obj = usuario_EventoRepository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}
	
	
}
