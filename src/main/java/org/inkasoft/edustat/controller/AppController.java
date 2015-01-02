package org.inkasoft.edustat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.inkasoft.edustat.model.Menu;
import org.inkasoft.edustat.model.Rol;
import org.inkasoft.edustat.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class AppController {
    private static final Logger LOGGER = Logger.getLogger(AppController.class);

    @RequestMapping(value="/app", method=RequestMethod.GET)
    public String index (Model model, HttpServletRequest request) throws JsonProcessingException {
        List<Menu> menus;
        HttpSession session;
        Usuario usuario;
        ObjectMapper objectMapper;
        String usuarioJson, menusJson;
        
        // load user
        LOGGER.debug("Loading user from session...");
        session = request.getSession();
        usuario = (Usuario) session.getAttribute("usuario");
        LOGGER.debug("User loaded "+usuario.getUsername());
        
        // load menus
        LOGGER.debug("Loading availables for user");
        menus = new ArrayList<Menu>();
        for (Rol rol : usuario.getRols()) {
            menus.addAll(rol.getMenus());
        }
        
        // Serialize preloaded data
        LOGGER.debug("Serializing pre loaded data");
        objectMapper = new ObjectMapper();
        usuarioJson = objectMapper.writeValueAsString(usuario);
        menusJson = objectMapper.writeValueAsString(menus);
        
        // For display in site
        LOGGER.debug("Adding data to view");
        model.addAttribute("usuarioJson", usuarioJson);
        model.addAttribute("menusJson", menusJson);
        
        LOGGER.debug("Returning view");
        return "app/index";
    }

}
