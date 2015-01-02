package org.inkasoft.edustat.controller.api;

import org.inkasoft.edustat.model.Persona;
import org.inkasoft.edustat.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonaApiController {
    @Autowired PersonaService personaService;
    
    @RequestMapping(value={"/private/api/persona/{personaDni}"}, method=RequestMethod.GET)
    @ResponseBody
    public Persona findByDni (@PathVariable String personaDni) {
        return personaService.loadByDni(personaDni);
    }

}
