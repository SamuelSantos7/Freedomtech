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

import br.com.squad.Freedomtech.model.Usuario;
import br.com.squad.Freedomtech.repository.UsuarioRepository;



@RestController
@RequestMapping("/fredomtech")
@CrossOrigin("*")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioRepository repositoriu;
	
	@GetMapping
	public ResponseEntity<List<Usuario>>getAll()
	{
		return ResponseEntity.ok(repositoriu.findAll());
	}
	
	@GetMapping("/findbyid/{Id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long Id)
	{
		return repositoriu.findById(Id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
		//return ResponseEntity.status(200).body(repositoriu.findById(Id).get());
	
	}
	
	@GetMapping("/findByNome/{descricao}")
	public ResponseEntity<List<Usuario>> GetByNome(@PathVariable String descricao) {
		return ResponseEntity.ok(repositoriu.findAllByNomeContainingIgnoreCase(descricao));

	}
	
	@PostMapping
	public ResponseEntity<Usuario> criar(@Valid @RequestBody Usuario categoria)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoriu.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario categoria)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repositoriu.save(categoria));
	}
	
	@DeleteMapping("/excluir/{Id}")
	public void excluir(@PathVariable Long Id)
	{
		repositoriu.deleteById(Id);
	}

}
