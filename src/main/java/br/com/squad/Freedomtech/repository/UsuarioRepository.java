package br.com.squad.Freedomtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.squad.Freedomtech.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
	
	
	
	
}
