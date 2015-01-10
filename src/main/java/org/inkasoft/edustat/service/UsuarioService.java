package org.inkasoft.edustat.service;

import java.util.List;

import org.inkasoft.edustat.model.Usuario;
import org.inkasoft.edustat.util.exceptions.RestriccionSeguridadException;
import org.inkasoft.edustat.util.exceptions.UsuarioYaExisteException;

public interface UsuarioService {

    public boolean userExists (String username);
    
    public Usuario create (Usuario usuario) throws UsuarioYaExisteException;
    public Usuario loadById (String username);
    public List<Usuario> findAll ();
    public Usuario update (String username, Usuario usuario) throws RestriccionSeguridadException;
    public void delete (String username);
    
    public List<Usuario> searchByUsername (String username);

}
