package org.inkasoft.edustat.repository;

import java.util.List;

import org.inkasoft.edustat.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    
    @Query("from Usuario where username like '%'||:username||'%'")
    public List<Usuario> searchByUsername (@Param(value = "username") String username);

}
