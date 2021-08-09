package br.com.squad.Freedomtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.squad.Freedomtech.model.PostagemModel;

public interface PostagemRepository extends JpaRepository<PostagemModel, Long> {

	public List<PostagemModel> findAllByTextoContainingIgnoreCase(String texto);

}
