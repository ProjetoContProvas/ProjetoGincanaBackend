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
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	//método que retorna todos os cadastros no banco de dados
	@GetMapping("/listall")
	public List<UsuarioModel> listall() {
		List<UsuarioModel> result = repository.findAll();
		return result;
	}

	//método que retorna um cadastro expecifico do banco de dados de acordo com o ID
	@GetMapping(value = "/{id}")
	public UsuarioModel findById(@PathVariable Integer id) {
		Optional<UsuarioModel> obj = repository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}

	// método que cadastra um objeto no banco de dados.
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

	//método que deleta um cadastro do banco de dados de acordo com  ID
	@DeleteMapping("/{id}")
	public ResponseEntity<UsuarioModel> delete(@PathVariable Integer id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	//método que modifica um cadastro existente no banco de dados.
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
