package br.com.squad.Freedomtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.squad.Freedomtech.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Integer> {

	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);

}
