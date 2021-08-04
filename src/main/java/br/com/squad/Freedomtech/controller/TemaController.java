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

import br.com.squad.Freedomtech.model.TemaModel;
import br.com.squad.Freedomtech.repository.TemaRepository;

@RestController
@RequestMapping("/pi/tema")
@CrossOrigin("*")
public class TemaController {

	@Autowired
	private TemaRepository repositoriu;

	@GetMapping
	public ResponseEntity<List<TemaModel>> getAll() {
		return ResponseEntity.ok(repositoriu.findAll());
	}

	@GetMapping("/findbyid/{Id}")
	public ResponseEntity<TemaModel> getById(@PathVariable Long Id) {
		return repositoriu.findById(Id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		// return ResponseEntity.status(200).body(repositoriu.findById(Id).get());

	}

	@GetMapping("/findByTitulo/{titulo}")
	public ResponseEntity<List<TemaModel>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repositoriu.findAllByTituloContainingIgnoreCase(titulo));

	}

	@PostMapping
	public ResponseEntity<TemaModel> criar(@Valid @RequestBody TemaModel tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoriu.save(tema));
	}

	@PutMapping
	public ResponseEntity<TemaModel> atualizar(@Valid @RequestBody TemaModel tema) {
		return ResponseEntity.status(HttpStatus.OK).body(repositoriu.save(tema));
	}

	@DeleteMapping("/excluir/{Id}")
	public void excluir(@PathVariable Long Id) {
		repositoriu.deleteById(Id);
	}

}
