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

/*Essa é uma classe de Controller, é a classe resposavél pela criação de metodos, como o CRUD por exemplo.
 * 
 * @RestController --> permite definir um controller com características REST.
 * @RequestMapping --> Com esse anotation configuramos a rota da classe. (ao colocarmos a rota no navegador será direcionado para essa classe e poderá ter acesso aos metodos .
 * @Autowired --> Injeção automatica, com esse anotation, não precisamos ficar criando estagancias de outra classe dentro de cada mátodo
 * @GetMapping --> indica que o método é um método de busca, ele retornará uma informação (Ex:.. retorna uma lista do banco de dados);
*/

@RestController
@RequestMapping("/usuario_evento")
public class Usuario_EventoController {
	
	@Autowired
	private Usuario_EventoRepository usuario_EventoRepository;
	
	//método que retorna todos os cadastros no banco de dados
	@GetMapping("/listall")
	public List<Usuario_EventoModel> listall() {
		List<Usuario_EventoModel> result = usuario_EventoRepository.findAll();
		return result;
	}
	
	//método que retorna um cadastro expecifico do banco de dados de acordo com o ID
	@GetMapping("/{id}")
	public Usuario_EventoModel findById(@PathVariable Usuario_EventoModelID id) {
		Optional<Usuario_EventoModel> obj = usuario_EventoRepository.findById(id);
		if (obj.isPresent())
			return obj.get();
		return null;
	}
	
	
}
