package br.edu.ifba.BackGincana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.BackGincana.model.Nota_CriterioModel;
import br.edu.ifba.BackGincana.repository.Nota_CriterioRepository;

@RestController
@RequestMapping("/nota_criterio")
public class Nota_CriterioController {

	@Autowired
	private Nota_CriterioRepository nota_CriterioRepository;

	@GetMapping("/teste")
	public String teste() {
		return "Testando Rota";
	}

	@GetMapping("/listall")
	public List<Nota_CriterioModel> listall() {
		List<Nota_CriterioModel> result = nota_CriterioRepository.findAll();
		return result;
	}

}
