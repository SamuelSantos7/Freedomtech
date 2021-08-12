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
import org.springframework.web.bind.annotation.RestController;

import br.com.squad.Freedomtech.model.Categoria;

import br.com.squad.Freedomtech.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repositoriu;

	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {

		return ResponseEntity.ok(repositoriu.findAll());
	}

	@GetMapping("/{Id}")
	public ResponseEntity<Categoria> getById(@PathVariable long id) {
		return repositoriu.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		// return ResponseEntity.status(200).body(repositoriu.findById(Id).get());

	}

	@GetMapping("/Categoria/{categoria}")
	public ResponseEntity<List<Categoria>> GetByCategoria(@PathVariable String categoria) {
		return ResponseEntity.ok(repositoriu.findAllByCategoriaContainingIgnoreCase(categoria));

	}

	@PostMapping
	public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoriu.save(categoria));
	}

	@PutMapping
	public ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {
		return ResponseEntity.ok(repositoriu.save(categoria));
	}

	@DeleteMapping("/{Id}")
	public void delete(@PathVariable long id) {
		repositoriu.deleteById(id);
	}

}
