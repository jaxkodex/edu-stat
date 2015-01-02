package org.inkasoft.edustat.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.inkasoft.edustat.model.Usuario;
import org.inkasoft.edustat.service.PersonaService;
import org.inkasoft.edustat.service.UsuarioService;
import org.inkasoft.edustat.util.exceptions.ApiControllerException;
import org.inkasoft.edustat.util.exceptions.RestriccionSeguridadException;
import org.inkasoft.edustat.util.exceptions.UsuarioYaExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsuarioApiController {
    private static final Logger LOGGER = Logger.getLogger(UsuarioApiController.class);
    
    @Autowired UsuarioService usuarioService;
    @Autowired PersonaService personaService;

    @RequestMapping(value="/public/api/usuario", method=RequestMethod.GET)
    @ResponseBody
    public List<Usuario> search (@RequestParam(required=false, defaultValue="") String query) {
        return usuarioService.searchByUsername(query);
    }

    @RequestMapping(value="/private/api/usuario/{username}", method=RequestMethod.PUT)
    @ResponseBody
    public Usuario updateOrCreate (@RequestBody Usuario usuario,
            HttpServletRequest request) throws ApiControllerException {
        HttpSession session;
        Usuario sessionUser;
        
        // Verify if user exists, if it does not, we assume it means create
        if (!usuarioService.userExists(usuario.getUsername())) {
            try {
                return usuarioService.create(usuario);
            } catch (UsuarioYaExisteException e) {
                LOGGER.error("Usuario ya existe", e);
                throw new ApiControllerException("No se puede ", e);
            }
        }
        
        // Load user from session so that we can update it
        session = request.getSession();
        sessionUser = (Usuario) session.getAttribute("usuario");
        
        try {
            usuarioService.update(sessionUser.getUsername(), usuario);
        } catch (RestriccionSeguridadException e) {
            LOGGER.error("Error de seguridad", e);
            throw new ApiControllerException("Error de seguridad", e);
        }
        
        // update user data
        session.setAttribute("usuario", usuario);
        
        return sessionUser;
    }
    
    
}
