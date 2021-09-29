package br.com.squad.Freedomtech.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CategoriaTest {

	@Test
	public void TestePostagem() {
		Categoria categoria = new Categoria();
		
		categoria.setCategoria("noticia");
		categoria.setId(2);
	
		
		assertEquals("noticia",categoria.getCategoria());
		assertEquals(2,categoria.getId());
	
}
}

	