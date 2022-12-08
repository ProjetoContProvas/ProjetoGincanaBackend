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

import br.edu.ifba.BackGincana.model.EquipeModel;
import br.edu.ifba.BackGincana.repository.EquipeRepository;

@RestController
@RequestMapping(value = "/equipe")
public class EquipeController {

	@Autowired
	private EquipeRepository repository;

	@GetMapping("/teste")
	public String teste() {
		System.out.println("Entrou");
		return "Testando Rota";
	}

	@GetMapping("/listall")
	public List<EquipeModel> findall() {
		System.out.println("Entrou aqui");
		return (List<EquipeModel>) repository.findAll();
	}

	@GetMapping("/{id}")
	public EquipeModel findById(@PathVariable("id") Integer id) {
		Optional<EquipeModel> obj = repository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean insert(@RequestBody EquipeModel model) {
		System.out.println("server - insert: " + model);
		try {
			repository.save(model);
			System.out.println("server - insert: TRUE");
			return true;
		} catch (Exception e) {
			System.out.println("server - insert: FALSE");
			e.printStackTrace();
			return false;
		}
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public boolean delete(@PathVariable("id") Integer id) {
		System.out.println("delete");
		try {
			repository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<EquipeModel> update(@PathVariable("id") Integer id, @RequestBody EquipeModel equipeModel) {
		var p = repository.findById(id);
		if (p.isPresent()) {
			var equipe = p.get();
			if (equipeModel.getNome_Equipe() != null)
				equipe.setNome_Equipe(equipeModel.getNome_Equipe());
			if (equipeModel.getDescricao_Equipe() != null)
				equipe.setDescricao_Equipe(equipeModel.getDescricao_Equipe());
			if(equipeModel.getGincana() != null)
				equipe.setGincana(equipeModel.getGincana());
			if(equipeModel.getCurso() != null)
				equipe.setCurso(equipeModel.getCurso());
			if(equipeModel.getUsuario() != null)
				equipe.setUsuario(equipeModel.getUsuario());
			repository.save(equipe);
			return ResponseEntity.ok(equipe);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	/*
	@GetMapping("/galeria/{id}")
	public List<EquipeModel> buscarPorGaleria(@PathVariable("id") Integer id ) {
		List<EquipeModel> list = this.repository.findAll();
		
		return list;
	} */
	
	
	
	
	
	
	
	

}
