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

import br.edu.ifba.BackGincana.model.CriterioModel;
import br.edu.ifba.BackGincana.repository.CriterioRepository;

/*Essa é uma classe de Controller, é a classe resposavél pela criação de metodos, como o CRUD por exemplo.
 * 
 * @RestController --> permite definir um controller com características REST.
 * @RequestMapping --> Com esse anotation configuramos a rota da classe. (ao colocarmos a rota no navegador será direcionado para essa classe e poderá ter acesso aos metodos .
 * @Autowired --> Injeção automatica, com esse anotation, não precisamos ficar criando estagancias de outra classe dentro de cada mátodo
 * @GetMapping --> indica que o método é um método de busca, ele retornará uma informação (Ex:.. retorna uma lista do banco de dados);
 * @PostMapping --> indica que o metodo é um metodo de envio, (EX:.. envia um objeto para ser salvo no banco de dados)
 * @ResponseStatus --> Apenas um anotation de tratamento de excepitons (erros). pode ser observado no Insomia.
 * @PathVariable --> desserializa um 'id' passado pela URL. geralmente é usado em metodo DELETE e UPDATE; 
 * @RequestBody --> Reliza uma conversão que permite que um objeto Json seja entendido pelo java e converte esse objeto para um tipo desejado!
 * */
//método para testar rota
//método que retorna todos os cadastros no banco de dados
//método que retorna um cadastro expecifico do banco de dados de acordo com o ID
// método que cadastra um objeto no banco de dados.
//método que deleta um cadastro do banco de dados de acordo com  ID
//método que modifica um cadastro existente no banco de dados.


@RestController
@RequestMapping(value = "/criterio")
public class CriterioController {

	@Autowired
	private CriterioRepository repository;
	
	// método para testar rota

	@GetMapping("/teste")
	public String teste() {
		System.out.println("Entrou");
		return "Testando Rota";
	}
	

	//método que retorna todos os cadastros no banco de dados
	@GetMapping("/listall")
	public List<CriterioModel> findall() {
		System.out.println("Entrou aqui");
		return (List<CriterioModel>) repository.findAll();
	}
	

	//método que retorna um cadastro expecifico do banco de dados de acordo com o ID
	@GetMapping("/{id}")
	public CriterioModel findById(@PathVariable("id") Integer id) {
		Optional<CriterioModel> obj = repository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}

	// método que cadastra um objeto no banco de dados.
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean insert(@RequestBody CriterioModel model) {
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

	//método que deleta um cadastro do banco de dados de acordo com  ID
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

	//método que modifica um cadastro existente no banco de dados.
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<CriterioModel> update(@PathVariable("id") Integer id, @RequestBody CriterioModel criterioModel) {
		var p = repository.findById(id);
		if (p.isPresent()) {
			var criterio = p.get();
			if (criterioModel.getNome_Criterio() != null)
				criterio.setNome_Criterio(criterioModel.getNome_Criterio());
			if (criterioModel.getPontuacao_min_Criterio() != 0)
				criterio.setPontuacao_min_Criterio(criterioModel.getPontuacao_min_Criterio());
			if (criterioModel.getPontuacao_max_Criterio() != 0)
				criterio.setPontuacao_max_Criterio(criterioModel.getPontuacao_max_Criterio());
			if(criterioModel.getEvento() != null)
				criterio.setEvento(criterioModel.getEvento());
			repository.save(criterio);
			return ResponseEntity.ok(criterio);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
