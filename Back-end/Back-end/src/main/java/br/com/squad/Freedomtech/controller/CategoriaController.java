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

import br.com.squad.Freedomtech.model.Categoria;

import br.com.squad.Freedomtech.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repositoriC;

	@GetMapping("/todas")
	public ResponseEntity<List<Categoria>> pegarTodos() {

		return ResponseEntity.ok(repositoriC.findAll());
	}

	@GetMapping("/{id_categoria}")
	public ResponseEntity<Categoria> pegarCategoriaPorId(@PathVariable(value = "id_categoria") Integer id) {
		return repositoriC.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/categoria/{categoria}")
	public ResponseEntity<List<Categoria>> pegarPorCategoria(@PathVariable String categoria) {
		return ResponseEntity.ok(repositoriC.findAllByCategoriaContainingIgnoreCase(categoria));

	}

	@PostMapping("/salvar")
	public ResponseEntity<Categoria> salvarCategoria(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoriC.save(categoria));
	}

	@PutMapping("/alterar/{id}")
	public ResponseEntity<Categoria> alterarCategoria(@Valid @RequestBody Categoria categoria) {
		return repositoriC.findById(categoria.getId()).map(resp -> ResponseEntity.ok(repositoriC.save(categoria)))
				.orElse(ResponseEntity.status(400).build());
	}

	@DeleteMapping("/deletar/{id_categoria}")
	public ResponseEntity<Object> deletarCategoria(@PathVariable(value = "id_categoria") Integer id) {
		return repositoriC.findById(id).map(resp -> {
			repositoriC.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseGet(() -> {
			return ResponseEntity.notFound().build();
		});
	}

}
