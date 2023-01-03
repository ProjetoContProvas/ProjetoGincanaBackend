package br.edu.ifba.BackGincana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.BackGincana.model.Nota_CriterioModel;
import br.edu.ifba.BackGincana.repository.Nota_CriterioRepository;
/*Essa é uma classe de Controller, é a classe resposavél pela criação de metodos, como o CRUD por exemplo.
 * 
 * @RestController --> permite definir um controller com características REST.
 * @RequestMapping --> Com esse anotation configuramos a rota da classe. (ao colocarmos a rota no navegador será direcionado para essa classe e poderá ter acesso aos metodos .
 * @Autowired --> Injeção automatica, com esse anotation, não precisamos ficar criando estagancias de outra classe dentro de cada mátodo
 * @GetMapping --> indica que o método é um método de busca, ele retornará uma informação (Ex:.. retorna uma lista do banco de dados);
*/



@RestController
@RequestMapping("/nota_criterio")
public class Nota_CriterioController {

	@Autowired
	private Nota_CriterioRepository nota_CriterioRepository;

	//método para testar rota
	@GetMapping("/teste")
	public String teste() {
		return "Testando Rota";
	}

	//método que retorna todos os cadastros no banco de dados
	@GetMapping("/listall")
	public List<Nota_CriterioModel> listall() {
		List<Nota_CriterioModel> result = nota_CriterioRepository.findAll();
		return result;
	}
	
	
	
	
}
