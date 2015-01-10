package org.inkasoft.edustat.repository;

import org.inkasoft.edustat.model.InstitucionEducativaHasDocente;
import org.inkasoft.edustat.model.InstitucionEducativaHasDocentePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteHasInsitucionEducativaRepository extends JpaRepository<InstitucionEducativaHasDocente, InstitucionEducativaHasDocentePK> {

}
