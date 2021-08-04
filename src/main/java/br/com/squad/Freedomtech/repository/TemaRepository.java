package br.com.squad.Freedomtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.squad.Freedomtech.model.TemaModel;

public interface TemaRepository extends JpaRepository<TemaModel, Long> {

	public List<TemaModel> findAllByTituloContainingIgnoreCase(String titulo);

}
