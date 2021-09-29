package br.com.squad.Freedomtech.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.squad.Freedomtech.model.UserLogin;
import br.com.squad.Freedomtech.model.Usuario;
import br.com.squad.Freedomtech.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	public Optional<Object> cadastrarUsuario(Usuario novoUsuario) {
		return repository.findByLogin(novoUsuario.getLogin()).map(usuarioExistente -> {
			return Optional.empty();
		}).orElseGet(() -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptografada = encoder.encode(novoUsuario.getSenha());
			novoUsuario.setSenha(senhaCriptografada);
			return Optional.ofNullable(repository.save(novoUsuario));
		});
	}

	public Optional<UserLogin> Logar(Optional<UserLogin> user) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Usuario> usuario = repository.findByLogin(user.get().getLogin());

        if (usuario.isPresent()) {
            if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

                String auth = user.get().getLogin() + ":" + user.get().getSenha();
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);

                user.get().setToken(authHeader);
                user.get().setId(usuario.get().getId());
                user.get().setNome(usuario.get().getNome());
                user.get().setSenha(usuario.get().getSenha());
                user.get().setFoto(usuario.get().getFoto());  
                
                return user;

            }
        }
        return null;
    }
	
	public Optional<Usuario> alterarUsuario(Usuario usuarioParaAlterar) {
		return repository.findById(usuarioParaAlterar.getId()).map(usuarioExistente -> {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCriptografada = encoder.encode(usuarioParaAlterar.getSenha());

			usuarioExistente.setSenha(senhaCriptografada);
			usuarioExistente.setEmail(usuarioParaAlterar.getEmail());
			usuarioExistente.setFoto(usuarioParaAlterar.getFoto());
			usuarioExistente.setLinkedin(usuarioParaAlterar.getLinkedin());
			usuarioExistente.setNome(usuarioParaAlterar.getNome());
			return Optional.ofNullable(repository.save(usuarioExistente));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}

}