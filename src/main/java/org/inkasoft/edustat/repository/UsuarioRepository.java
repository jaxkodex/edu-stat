package org.inkasoft.edustat.repository;

import org.inkasoft.edustat.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
