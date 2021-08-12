package br.com.squad.Freedomtech.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.squad.Freedomtech.Service.PostagemService;
import br.com.squad.Freedomtech.model.Postagem;

import br.com.squad.Freedomtech.repository.PostagemRepository;


@RestController
@RequestMapping("/api/v1/postagem")
@CrossOrigin("*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repositoriu;
	
	@Autowired
	private PostagemService services;
	
	@GetMapping("/todas")
	public ResponseEntity<Object> buscarTodas() {
		List<Postagem> listaPostagem = repositoriu.findAll();

		if (listaPostagem.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaPostagem);
		}

	}
	
	@GetMapping("/{id_postagem}")
	public ResponseEntity<Postagem> buscarPorId(@PathVariable(value = "id_postagem") Long id) {
		Optional<Postagem> objetoPostagem = repositoriu.findById(id);
		if (objetoPostagem.isPresent()) {
			return ResponseEntity.status(200).body(objetoPostagem.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}
	
	@GetMapping("/pesquisa")
	public ResponseEntity<List<Postagem>> buscarPorTitulo(@RequestParam(defaultValue = "") String titulo) {
		return ResponseEntity.status(200).body(repositoriu.findAllByTituloContainingIgnoreCase(titulo));
	}
	

	@PostMapping("/cadastrar")
	public ResponseEntity<Object> cadastrarPostagem(@Valid @RequestBody Postagem novaPostagem) {
		Optional<?> objetoCadastrado = services.cadastrarPostagem(novaPostagem);

		if (objetoCadastrado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		} else {
			return ResponseEntity.status(400).build();
		}

	}
	
	@PutMapping("/alterar")
	public ResponseEntity<Object> alterar(@Valid @RequestBody Postagem postagemParaAlterar) {
		Optional<Postagem> objetoAlterado = services.alterarPostagem(postagemParaAlterar);

		if (objetoAlterado.isPresent()) {
			return ResponseEntity.status(201).body(objetoAlterado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}
	
	@DeleteMapping("/deletar/{id_postagem}")
	public ResponseEntity<Object> deletarPorId(@PathVariable(value = "id_postagem") Long idPostagem) {
		Optional<Postagem> objetoExistente = repositoriu.findById(idPostagem);
		if (objetoExistente.isPresent()) {
			repositoriu.deleteById(idPostagem);
			return ResponseEntity.status(200).build();
		} else {
			return ResponseEntity.status(400).build();
		}
		
	}
	
	

}
