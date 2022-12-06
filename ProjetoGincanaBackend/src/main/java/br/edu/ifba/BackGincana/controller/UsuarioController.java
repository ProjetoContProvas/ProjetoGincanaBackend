package br.edu.ifba.BackGincana.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.BackGincana.model.UsuarioModel;
import br.edu.ifba.BackGincana.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping("/listall")
	public List<UsuarioModel> listall() {
		List<UsuarioModel> result = repository.findAll();
		return result;
	}

	@GetMapping(value = "/{id}")
	public UsuarioModel findById(@PathVariable Integer id) {
		Optional<UsuarioModel> obj = repository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}

	@PostMapping
	public boolean insert(@RequestBody UsuarioModel usuario) {
		
		try {
			repository.save(usuario);
			System.out.println("server - insert: TRUE");
			return true;
		} catch (Exception e) {
			System.out.println("server - insert: FALSE");
			e.printStackTrace();
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioModel> delete(@PathVariable Integer id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UsuarioModel> update(@PathVariable Integer id, @RequestBody UsuarioModel usuarioModel) {
		var p = repository.findById(id);
        System.out.println("00000000000000000000000000000000-------------------->"+ usuarioModel);
		if (p.isPresent()) {
			var usuario = p.get();

			if (usuarioModel.getNome_Usuario() != null)
				usuario.setNome_Usuario(usuarioModel.getNome_Usuario());

			if (usuarioModel.getEmail_Usuario() != null)
				usuario.setEmail_Usuario(usuarioModel.getEmail_Usuario());

			if (usuarioModel.getSenha_Usuario() != null)
				usuario.setSenha_Usuario(usuarioModel.getSenha_Usuario());

			if (usuarioModel.getSexo_Usuario() != null)
				usuario.setSexo_Usuario(usuarioModel.getSenha_Usuario());

			if (usuarioModel.getData_cadastro_Usuario() != null)
				usuario.setData_cadastro_Usuario(usuarioModel.getData_cadastro_Usuario());
			
			if(usuario.getGincana() != null)
				usuario.setGincana(usuarioModel.getGincana());
			
			if(usuario.getPerfil() != null)
				usuario.setPerfil(usuarioModel.getPerfil());
			
			repository.save(usuario);
			return ResponseEntity.ok(usuario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
