package br.com.squad.Freedomtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import br.com.squad.Freedomtech.model.Postagem;


public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	public List<Postagem> findAllByTituloContainingIgnoreCase(String nome);
	
	public List<Postagem> findAllById(String Id);	
	
	
}
