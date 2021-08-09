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

import br.com.squad.Freedomtech.model.TarefaModel;
import br.com.squad.Freedomtech.repository.TarefaRepository;

@RestController
@RequestMapping("/pi/tarefa")
@CrossOrigin("*")
public class TarefaController {

	@Autowired
	private TarefaRepository repositoriu;

	@GetMapping
	public ResponseEntity<List<TarefaModel>> getAll() {
		return ResponseEntity.ok(repositoriu.findAll());
	}

	@GetMapping("/findbyid/{Id}")
	public ResponseEntity<TarefaModel> getById(@PathVariable Long Id) {
		return repositoriu.findById(Id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		// return ResponseEntity.status(200).body(repositoriu.findById(Id).get());

	}

	@GetMapping("/findByTarefa/{descricaoTarefa}")
	public ResponseEntity<List<TarefaModel>> GetById(@PathVariable String descricaoTarefa) {
		return ResponseEntity.ok(repositoriu.findAllByDescricaoTarefaContainingIgnoreCase(descricaoTarefa));

	}

	@PostMapping
	public ResponseEntity<TarefaModel> criar(@Valid @RequestBody TarefaModel tarefa) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoriu.save(tarefa));
	}

	// atualiza
	@PutMapping
	public ResponseEntity<TarefaModel> atualizar(@Valid @RequestBody TarefaModel tarefa) {
		return ResponseEntity.status(HttpStatus.OK).body(repositoriu.save(tarefa));
	}

	@DeleteMapping("/excluir/{Id}")
	public void excluir(@PathVariable Long Id) {
		repositoriu.deleteById(Id);
	}

}
