package br.com.squad.Freedomtech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.squad.Freedomtech.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

	public List<Categoria> findAllByCategoriaContainingIgnoreCase(String categoria);

	public Optional<Categoria> findById(int id);

}
