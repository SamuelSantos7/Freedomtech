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

import br.com.squad.Freedomtech.model.Postagem;

import br.com.squad.Freedomtech.repository.PostagemRepository;


@RestController
@RequestMapping("/Postagem")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repositoriu;
	
	@GetMapping
	public ResponseEntity<List<Postagem>>getAll()
	{
		return ResponseEntity.ok(repositoriu.findAll());
	}
	
	@GetMapping("/findbyid/{Id}")
	public ResponseEntity<Postagem> getById(@PathVariable Long Id)
	{
		return repositoriu.findById(Id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		//return ResponseEntity.status(200).body(repositoriu.findById(Id).get());
	
	}
	
	@GetMapping("/findByNome/{nome}")
	public ResponseEntity<List<Postagem>> GetByNome(@PathVariable String nome) {
		return ResponseEntity.ok(repositoriu.findAllByTituloContainingIgnoreCase(nome));

	}
	
	@PostMapping
	public ResponseEntity<Postagem> criar(@Valid @RequestBody Postagem postagem)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoriu.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> atualizar(@Valid @RequestBody Postagem postagem)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repositoriu.save(postagem));
	}
	
	@DeleteMapping("/excluir/{Id}")
	public void excluir(@PathVariable Long Id)
	{
		repositoriu.deleteById(Id);
	}
	
	
	

}
