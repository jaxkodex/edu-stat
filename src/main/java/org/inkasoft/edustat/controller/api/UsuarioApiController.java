package org.inkasoft.edustat.controller.api;

import java.util.List;

import org.inkasoft.edustat.model.Usuario;
import org.inkasoft.edustat.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsuarioApiController {
	@Autowired UsuarioService usuarioService;

	@RequestMapping(value="/public/api/usuario", method=RequestMethod.GET)
	@ResponseBody
	public List<Usuario> search (@RequestParam(required=false, defaultValue="") String query) throws Exception {
		return usuarioService.searchByUsername(query);
	}

	@RequestMapping(value="/public/api/usuario/{username}", method=RequestMethod.PUT)
	@ResponseBody
	public Usuario updateOrCreate (@RequestBody Usuario usuario) throws Exception {
		Usuario existingUser = usuarioService.loadById(usuario.getUsername());
		if (existingUser == null) {
			return usuarioService.create(usuario);
		}
		// TODO Otherwhise do validation of logged in user and its information
		return usuarioService.update(usuario);
	}
}
