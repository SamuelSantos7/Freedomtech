package br.com.squad.Freedomtech.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.squad.Freedomtech.model.PostagemModel;
import br.com.squad.Freedomtech.repository.PostagemRepository;

@RestController
@RequestMapping("/pi/postagem")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repositoriu;

	@GetMapping
	public ResponseEntity<List<PostagemModel>> getAll() {
		return ResponseEntity.ok(repositoriu.findAll());
	}

	@GetMapping("/findbyid/{Id}")
	public ResponseEntity<PostagemModel> getById(@PathVariable Long Id) {
		return repositoriu.findById(Id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		// return ResponseEntity.status(200).body(repositoriu.findById(Id).get());

	}

	@GetMapping("/findByTexto/{texto}")
	public ResponseEntity<List<PostagemModel>> GetById(@PathVariable String texto) {
		return ResponseEntity.ok(repositoriu.findAllByTextoContainingIgnoreCase(texto));

	}

	@PostMapping
	public ResponseEntity<PostagemModel> criar(@Valid @RequestBody PostagemModel postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoriu.save(postagem));
	}

//atualiza
	@PutMapping
	public ResponseEntity<PostagemModel> atualizar(@Valid @RequestBody PostagemModel postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repositoriu.save(postagem));
	}

	@DeleteMapping("/excluir/{Id}")
	public void excluir(@PathVariable Long Id) {
		repositoriu.deleteById(Id);
	}

}
