package br.com.squad.Freedomtech.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

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
import br.com.squad.Freedomtech.service.PostagemService;

@RestController
@RequestMapping("/freedomtech/postagem")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repositoriP;

	@Autowired
	private PostagemService services;

	@GetMapping("/todas")
	public ResponseEntity<List<Postagem>> pegarTodas() {
		return ResponseEntity.ok(repositoriP.findAll());

	}

	@GetMapping("/{id_postagem}")
	public ResponseEntity<Postagem> pegarPostagemPorId(@PathVariable(value = "id_postagem") Long id) {
		return repositoriP.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/Titulo/{titulo}")
	public ResponseEntity<List<Postagem>> pegarPorTitulo(@PathVariable String titulo) {
		return ResponseEntity.status(200).body(repositoriP.findAllByTituloContainingIgnoreCase(titulo));
	}

	@GetMapping("/pesquisa")
	public ResponseEntity<List<Postagem>> pegarPorTitulo2(@RequestParam(defaultValue = "") String titulo) {
		return ResponseEntity.status(200).body(repositoriP.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping("/salvar")
	public ResponseEntity<Object> salvarPostagem(@Valid @RequestBody Postagem novaPostagem) {
		Optional<?> objetoCadastrado = services.cadastrarPostagem(novaPostagem);

		if (objetoCadastrado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		} else {
			return ResponseEntity.status(400).build();
		}

	}

	@PutMapping("/alterar")
	public ResponseEntity<Object> alterarPostagem(@Valid @RequestBody Postagem postagemParaAlterar) {
		Optional<Postagem> objetoAlterado = services.alterarPostagem(postagemParaAlterar);

		if (objetoAlterado.isPresent()) {
			return ResponseEntity.status(201).body(objetoAlterado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@DeleteMapping("/deletar/{id_postagem}")
	public ResponseEntity<Object> deletarPostagem(@PathVariable(value = "id_postagem") Long id) {
		return repositoriP.findById(id).map(resp -> {
			repositoriP.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseGet(() -> {
			return ResponseEntity.notFound().build();
		});

	}

}
