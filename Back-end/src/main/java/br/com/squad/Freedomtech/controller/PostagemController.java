package br.com.squad.Freedomtech.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.squad.Freedomtech.model.Postagem;

import br.com.squad.Freedomtech.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repositoriP;


	@GetMapping("/todas")
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repositoriP.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repositoriP.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repositoriP.findAllByTituloContainingIgnoreCase(titulo));
	}

	@GetMapping("/pesquisa")
	public ResponseEntity<List<Postagem>> pegarPorTitulo2(@RequestParam(defaultValue = "") String titulo) {
		return ResponseEntity.status(200).body(repositoriP.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping("/salvar")
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoriP.save(postagem));
	}

	@PutMapping("/alterar")
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repositoriP.save(postagem));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repositoriP.deleteById(id);
	}

}
