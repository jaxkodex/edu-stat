package org.inkasoft.edustat.repository;

import java.util.List;

import org.inkasoft.edustat.model.Seccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeccionRepository extends JpaRepository<Seccion, Integer> {

    public List<Seccion> findByGradoIdGrado (Integer idGrado);
    public List<Seccion> findByGradoNivelIdNivel (Integer idNivel);
    public List<Seccion> findBySeccionEstado (String estado);

}
