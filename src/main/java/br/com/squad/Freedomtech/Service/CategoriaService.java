package br.com.squad.Freedomtech.service;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad.Freedomtech.model.Categoria;
import br.com.squad.Freedomtech.repository.CategoriaRepository;



@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repositoryC;
	
	public Optional<Categoria> alterarCategoria(Categoria categoriaParaAlterar) {
		return repositoryC.findById(categoriaParaAlterar.getId()).map(categoriaExistente -> {
			categoriaExistente.setCategoria(categoriaParaAlterar.getCategoria());
			return Optional.ofNullable(repositoryC.save(categoriaExistente));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

}
