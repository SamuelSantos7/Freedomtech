package br.com.squad.Freedomtech.Service;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad.Freedomtech.model.Categoria;
import br.com.squad.Freedomtech.model.Postagem;
import br.com.squad.Freedomtech.repository.CategoriaRepository;
import br.com.squad.Freedomtech.repository.PostagemRepository;
import br.com.squad.Freedomtech.repository.UsuarioRepository;

@Service
public class PostagemService {

	@Autowired
	private PostagemRepository repositoryP;
	
	@Autowired
	private UsuarioRepository repositoryU;
	
	@Autowired
	private CategoriaRepository repositoryC;
	
	public Optional<?> cadastrarPostagem(Postagem novaPostagem) {
		Optional<Categoria> objetoExistente = repositoryC.findById(novaPostagem.getCategoria().getId());
		return repositoryU.findById(novaPostagem.getUsuario().getId()).map(usuarioExistente -> {
			if (objetoExistente.isPresent()) {
				novaPostagem.setUsuario(usuarioExistente);
				novaPostagem.setCategoria(objetoExistente.get());
				return Optional.ofNullable(repositoryP.save(novaPostagem));
			} else {
				return Optional.empty();
			}
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
	
	public Optional<Postagem> alterarPostagem(Postagem postagemParaAlterar) {
		return repositoryP.findById(postagemParaAlterar.getId()).map(postagemExistente -> {
			postagemExistente.setTitulo(postagemParaAlterar.getTitulo());
			postagemExistente.setDescricao(postagemParaAlterar.getDescricao());
			postagemExistente.setLink(postagemParaAlterar.getLink());
			postagemExistente.setResposta(postagemParaAlterar.getResposta());
			postagemExistente.setAprovado(postagemParaAlterar.getAprovado());
			return Optional.ofNullable(repositoryP.save(postagemExistente));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

	
	
	
}
