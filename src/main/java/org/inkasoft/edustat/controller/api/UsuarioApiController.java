package org.inkasoft.edustat.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.inkasoft.edustat.model.Persona;
import org.inkasoft.edustat.model.Usuario;
import org.inkasoft.edustat.service.PersonaService;
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
	@Autowired PersonaService personaService;

	@RequestMapping(value="/public/api/usuario", method=RequestMethod.GET)
	@ResponseBody
	public List<Usuario> search (@RequestParam(required=false, defaultValue="") String query) throws Exception {
		return usuarioService.searchByUsername(query);
	}

	@RequestMapping(value="/private/api/usuario/{username}", method=RequestMethod.PUT)
	@ResponseBody
	public Usuario updateOrCreate (@RequestBody Usuario usuario,
			HttpServletRequest request) throws Exception {
		HttpSession session;
		Usuario existingUser, sessionUser;
		Persona persona;
		
		// Verify if user exists, if it does not, we assume it means create
		existingUser = usuarioService.loadById(usuario.getUsername());
		if (existingUser == null) {
			return usuarioService.create(usuario);
		}
		
		// Load user from session so that we can update it
		session = request.getSession();
		sessionUser = (Usuario) session.getAttribute("usuario");
		
		// Verify if we are trying to update someone else's user account
		if (!sessionUser.getUsername().equals(usuario.getUsername())) {
			throw new Exception("Trying to load someone else's user account, come on!");
		}
		
		// By now we will only update user persona.
		// Trying to register some other DNI, let's verify if someone else registered it already
		if (usuario.getPersona().getPersonaDni() != null && 
				!sessionUser.getPersona().getPersonaDni().equals(usuario.getPersona().getPersonaDni())) {
			persona = personaService.loadByDni(usuario.getPersona().getPersonaDni());
			if (persona != null) {
				throw new Exception("La numero de DNI con el que desea registrarse, ya se encuentra,"
						+ " en uso, si cree que este es un error, contactese con el administrador.");
			}
			// person is ok, so let's register it
			sessionUser.getPersona().setPersonaDni(usuario.getPersona().getPersonaDni());
		}
		sessionUser.getPersona().setPersonaApaterno(usuario.getPersona().getPersonaApaterno());
		sessionUser.getPersona().setPersonaAmaterno(usuario.getPersona().getPersonaAmaterno());
		sessionUser.getPersona().setPersonaPnombre(usuario.getPersona().getPersonaPnombre());
		sessionUser.getPersona().setPersonaSnombre(usuario.getPersona().getPersonaSnombre());
		personaService.update(sessionUser.getPersona());
		
		// The user him self should not be able to assing his roles
		usuario.setRols(sessionUser.getRols());
		usuario.setPersona(sessionUser.getPersona());
		
		sessionUser = usuarioService.update(usuario);
		
		session.setAttribute("usuario", sessionUser);
		
		return sessionUser;
	}
}
