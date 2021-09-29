package br.com.squad.Freedomtech.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class PostagemTest {

	@Test
	public void TestePostagem() {
		Postagem postagem = new Postagem();
		Usuario usuario= new Usuario();
	     LocalDate data = LocalDate.of(2021,6,15);
	
		
        usuario.setLogin("maria");
		
           
		
		postagem.setDataPostagem(data);
		postagem.setDescricao("minha historia de vida novidade novidade");
		postagem.setId(1);
		postagem.setLink("http//www.negritude.com");
		postagem.setResposta("http//resposta");
		postagem.setTitulo("novidade novidade novidade");
		
		
	
		
	 

	    
		assertEquals(LocalDate.of(2021,06, 15), postagem.getDataPostagem());
		assertEquals("minha historia de vida novidade novidade", postagem.getDescricao());
		assertEquals(1, postagem.getId());
		assertEquals("http//www.negritude.com", postagem.getLink());
		assertEquals("http//resposta", postagem.getResposta());
		assertEquals("novidade novidade novidade", postagem.getTitulo());
		
	}
}