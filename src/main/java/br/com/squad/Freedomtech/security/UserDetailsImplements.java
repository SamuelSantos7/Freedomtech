package br.com.squad.Freedomtech.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.squad.Freedomtech.model.Usuario;

public class UserDetailsImplements implements UserDetails {

	
		private static final long serialVersionUID = 1L;
		
		private String email;
		private String senha;
		private List<GrantedAuthority> authorities;
		
		public UserDetailsImplements(Usuario usuario) {
			this.email = usuario.getEmail();
			this.senha = usuario.getSenha();
		}

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return authorities;
		}

		@Override
		public String getPassword() {
			return senha;
		}

		@Override
		public String getUsername() {
			return email;
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}

}
