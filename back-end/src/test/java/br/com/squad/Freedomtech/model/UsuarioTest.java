package br.com.squad.Freedomtech.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UsuarioTest {

@Test
public void  TesteUsuario(){
    Usuario usuario = new Usuario();
     
    usuario.setId(1);
    usuario.setCpf("123456789");
    usuario.setEmail("joelma@gmail.com");
    usuario.setFoto("joelma.jpg");
    usuario.setLogin("Jooh08");
    usuario.setSenha("123456");
    usuario.setCnpj("12325465789");


    assertEquals(1, usuario.getId());
    assertEquals("123456789",usuario.getCpf());
    assertEquals("joelma@gmail.com",usuario.getEmail());
    assertEquals("joelma.jpg",usuario.getFoto());
    assertEquals("Jooh08",usuario.getLogin());
    assertEquals("123456",usuario.getSenha());
    assertEquals("12325465789",usuario.getCnpj());



}
 


 
}