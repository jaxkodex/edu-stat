package org.inkasoft.edustat.service;

import org.inkasoft.edustat.model.Persona;

public interface PersonaService {

    public Persona loadByDni(String dni);

    public Persona update(Persona persona);

}
