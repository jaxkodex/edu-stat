package org.inkasoft.edustat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.inkasoft.edustat.model.Persona;
import org.inkasoft.edustat.model.Usuario;
import org.inkasoft.edustat.repository.PersonaRepository;
import org.inkasoft.edustat.repository.UsuarioRepository;
import org.inkasoft.edustat.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
	private final Logger logger = Logger.getLogger(UsuarioServiceImpl.class);
	
	@Autowired UsuarioRepository usuarioRepository;
	@Autowired PersonaRepository personaRepository;

	public Usuario create(Usuario usuario) throws Exception {
		Usuario usr = this.loadById(usuario.getUsername());
		if (usr != null) {
			throw new Exception("Usuario ya existe");
		}
		Persona persona = personaRepository.findOne(usuario.getPersona().getDni());
		if (persona == null) {
			personaRepository.save(usuario.getPersona());
		}
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		usuario.setPassword(encoder.encodePassword(usuario.getPassword(), ""));
		return usuarioRepository.save(usuario);
	}

	public Usuario loadById(String username) {
		return usuarioRepository.findOne(username);
	}

	public List<Usuario> findAll() {
		return null;
	}

	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void delete(String username) {
		usuarioRepository.delete(username);
	}

	public List<Usuario> searchByUsername(String username) {
		return usuarioRepository.searchByUsername(username);
	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		logger.debug("Usuario buscando ser loggeado: *"+String.format("%-12s", username)+"*");
		Usuario usuario = this.loadById(String.format("%-12s", username));
		logger.debug("Usuario: "+usuario);
		if (usuario == null) {
			logger.debug("Usuario no encontrado");
			throw new UsernameNotFoundException("El usuario no existe");
		}
		logger.debug("Logged in!");
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		User user = new User(usuario.getUsername(), usuario.getPassword(), authorities);
		return user;
	}

}
