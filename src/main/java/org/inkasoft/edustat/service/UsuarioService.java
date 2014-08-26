package org.inkasoft.edustat.service;

import java.util.List;

import org.inkasoft.edustat.model.Usuario;
import org.inkasoft.edustat.util.BaseCrudService;

public interface UsuarioService extends BaseCrudService<Usuario, String> {
	
	public List<Usuario> searchByUsername (String username);

}
