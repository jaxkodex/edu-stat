package org.inkasoft.edustat.service.impl;

import org.inkasoft.edustat.model.Persona;
import org.inkasoft.edustat.repository.PersonaRepository;
import org.inkasoft.edustat.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    public Persona loadByDni(String dni) {
        return personaRepository.findOne(dni);
    }

    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

}
