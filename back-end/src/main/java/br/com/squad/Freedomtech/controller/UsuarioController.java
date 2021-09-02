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
import org.springframework.web.bind.annotation.RestController;

import br.com.squad.Freedomtech.Service.UsuarioService;
import br.com.squad.Freedomtech.model.Usuario;
import br.com.squad.Freedomtech.model.userLogin;
import br.com.squad.Freedomtech.repository.UsuarioRepository;



@RestController
@RequestMapping("/freedomtech/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repositoriU;

	@Autowired
	private UsuarioService service;

	@GetMapping("/todes")
	public ResponseEntity<List<Usuario>> pegarTodes() {
		return ResponseEntity.ok(repositoriU.findAll());
	}

	@GetMapping("/{id_usuario}")
	public ResponseEntity<Usuario> pegarUsuarioPorId(@PathVariable(value = "id_usuario") Integer Id) {
		return repositoriU.findById(Id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/Nome/{nome}")
	public ResponseEntity<List<Usuario>> pegarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(repositoriU.findAllByNomeContainingIgnoreCase(nome));

	}

	@PostMapping("/salvar")
	public ResponseEntity<Object> salvarUsuario(@Valid @RequestBody Usuario novoUsuario) {
		Optional<Object> objetoCadastrado = service.cadastrarUsuario(novoUsuario);

		if (objetoCadastrado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		} else {
			return ResponseEntity.status(400).build();
		}

	}

	@SuppressWarnings("rawtypes")
	@PostMapping("/logar")
	public ResponseEntity logarUsuario(@Valid @RequestBody userLogin loginSenha) {
		Optional objetoCredenciado = service.pegarCredenciais(loginSenha);

		if (objetoCredenciado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCredenciado.get());
		} else {
			return ResponseEntity.status(400).build();
		}

	}

	@SuppressWarnings("rawtypes")
	@PutMapping("/alterar")
	public ResponseEntity alterarUsuario(@Valid @RequestBody Usuario usuarioParaSerAlterado) {
		Optional objetoAlterado = service.alterarUsuario(usuarioParaSerAlterado);

		if (objetoAlterado.isPresent()) {
			return ResponseEntity.status(201).body(objetoAlterado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@DeleteMapping("/deletar/{id_usuario}")
	public ResponseEntity<Object> deletarUsuario(@PathVariable(value = "id_usuario") Integer id) {
		return repositoriU.findById(id).map(resp -> {
			repositoriU.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElseGet(() -> {
			return ResponseEntity.notFound().build();
		});
	}

}
