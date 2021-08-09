package br.com.squad.Freedomtech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.squad.Freedomtech.model.TarefaModel;

public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {

	public List<TarefaModel> findAllByDescricaoTarefaContainingIgnoreCase(String descricaoTarefa);
}
