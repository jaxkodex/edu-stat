package org.inkasoft.edustat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.inkasoft.edustat.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
	private final Logger logger = Logger.getLogger(AppController.class);
	
	@RequestMapping(value="/app", method=RequestMethod.GET)
	public String index (HttpServletRequest request) {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		logger.info("Usuario logeado: "+usuario.getUsername());
		return "app/index";
	}

}
