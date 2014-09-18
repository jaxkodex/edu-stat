package org.inkasoft.edustat.util.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.inkasoft.edustat.model.Usuario;
import org.inkasoft.edustat.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

//SavedRequestAwareAuthenticationSuccessHandler
@Component
public class AuthSuccessFilter extends SimpleUrlAuthenticationSuccessHandler { //implements AuthenticationSuccessHandler { // extends BasicAuthenticationFilter {
	private static Logger logger = Logger.getLogger(AuthSuccessFilter.class);
	
	@Autowired UsuarioService usuarioService;
	
	public AuthSuccessFilter () {
		this.setDefaultTargetUrl("/app");// Should not do this
	}
	public AuthSuccessFilter (String defaultTargetUrl) {
		super(defaultTargetUrl);
	}

	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth) throws IOException,
			ServletException {
		HttpSession session = request.getSession();
		String username = auth.getName();
		Usuario usuario = usuarioService.loadById(username);
		session.setAttribute("usuario", usuario);
		logger.debug("Data saved to session "+usuario.getUsername()+" should redirect to "+this.getDefaultTargetUrl());
		logger.debug("Authorities "+usuario.getRols());
		logger.debug("Authorities "+auth.getAuthorities());
		for (GrantedAuthority a : auth.getAuthorities()) {
			logger.debug("Granted: "+a.getAuthority());
		}
		super.onAuthenticationSuccess(request, response, auth);
	}
	
	
}
