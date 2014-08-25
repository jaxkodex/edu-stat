package org.inkasoft.edustat.service.impl;

import java.util.List;

import org.inkasoft.edustat.model.Usuario;
import org.inkasoft.edustat.repository.PersonaRepository;
import org.inkasoft.edustat.repository.UsuarioRepository;
import org.inkasoft.edustat.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired UsuarioRepository usuarioRepository;
	@Autowired PersonaRepository personaRepository;

	public Usuario create(Usuario usuario) throws Exception {
		Usuario usr = this.loadById(usuario.getUsername());
		if (usr != null) {
			throw new Exception("Usuario ya existe");
		}
		personaRepository.save(usuario.getPersona());
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

}
