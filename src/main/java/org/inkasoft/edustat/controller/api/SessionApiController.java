package org.inkasoft.edustat.controller.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.inkasoft.edustat.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SessionApiController {
	
	@RequestMapping(value="/private/session", method=RequestMethod.GET)
	@ResponseBody
	public Usuario getSession (HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		return usuario;
	}

	@RequestMapping(value="/private/session/{sessionId}", method=RequestMethod.GET)
	@ResponseBody
	public Usuario getSessionModel (HttpServletRequest request) {
		return getSession(request);
	}

}
