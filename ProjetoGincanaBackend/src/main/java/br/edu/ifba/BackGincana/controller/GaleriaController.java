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

import br.edu.ifba.BackGincana.model.GaleriaModel;
import br.edu.ifba.BackGincana.repository.GaleriaRepository;

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





@RestController
@RequestMapping(value = "/galeria")
public class GaleriaController {

	@Autowired
	private GaleriaRepository repository;
	
	//método para testar rota
	@GetMapping("/teste")
	public String teste() {
		System.out.println("Entrou");
		return "Testando Rota";
	}

	//método que retorna todos os cadastros no banco de dados
	@GetMapping("/listall")
	public List<GaleriaModel> findall() {
		System.out.println("Entrou aqui");
		return (List<GaleriaModel>) repository.findAll();
	}

	//método que retorna um cadastro expecifico do banco de dados de acordo com o ID
	@GetMapping("/{id}")
	public GaleriaModel findById(@PathVariable("id") Integer id) {
		Optional<GaleriaModel> obj = repository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}

	// método que cadastra um objeto no banco de dados.
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean insert(@RequestBody GaleriaModel model) {
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
	public ResponseEntity<GaleriaModel> update(@PathVariable("id") Integer id, @RequestBody GaleriaModel galeriaModel) {
		var p = repository.findById(id);
		if (p.isPresent()) {
			var galeria = p.get();
			if (galeriaModel.getNome_Galeria() != null)
				galeria.setNome_Galeria(galeriaModel.getNome_Galeria());
			if (galeriaModel.getDescricao_Galeria() != null)
				galeria.setDescricao_Galeria(galeriaModel.getDescricao_Galeria());
			if(galeriaModel.getGincana() != null)
				galeria.setGincana(galeriaModel.getGincana());
			repository.save(galeria);
			return ResponseEntity.ok(galeria);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
