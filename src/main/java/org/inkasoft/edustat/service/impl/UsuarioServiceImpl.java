package org.inkasoft.edustat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.inkasoft.edustat.model.Persona;
import org.inkasoft.edustat.model.Rol;
import org.inkasoft.edustat.model.Usuario;
import org.inkasoft.edustat.repository.PersonaRepository;
import org.inkasoft.edustat.repository.UsuarioRepository;
import org.inkasoft.edustat.service.UsuarioService;
import org.inkasoft.edustat.util.exceptions.RestriccionSeguridadException;
import org.inkasoft.edustat.util.exceptions.UsuarioYaExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {
    private static final Logger LOGGER = Logger.getLogger(UsuarioServiceImpl.class);
    
    @Autowired UsuarioRepository usuarioRepository;
    @Autowired PersonaRepository personaRepository;

    public Usuario create(Usuario usuario) throws UsuarioYaExisteException {
        Usuario usr = this.loadById(usuario.getUsername());
        if (usr != null) {
            throw new UsuarioYaExisteException("Usuario ya existe");
        }
        Persona persona = personaRepository.findOne(usuario.getPersona().getPersonaDni());
        if (persona == null) {
            personaRepository.save(usuario.getPersona());
        }
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        usuario.setPassword(encoder.encodePassword(usuario.getPassword(), ""));
        return usuarioRepository.save(usuario);
    }

    public Usuario loadById(String username) {
        return usuarioRepository.findOne(username);
    }

    public List<Usuario> findAll() {
        List<Usuario> usuarios;
        
        usuarios = new ArrayList<Usuario>();
        return usuarios;
    }

    public Usuario update(String username, Usuario usuario)  throws RestriccionSeguridadException {
        Usuario usuarioGuardado = usuarioRepository.findOne(username);
        
        if (!usuarioGuardado.getUsername().equals(usuario.getUsername())) {
            throw new RestriccionSeguridadException("Trata de actualizar un usuario que no le corresponde. Usuario: "
                    +username+" trató de modificar "+usuario.getUsername());
        }
        
        // update persona data
        personaRepository.save(usuario.getPersona());
        return usuarioRepository.save(usuario);
    }

    public void delete(String username) {
        usuarioRepository.delete(username);
    }

    public List<Usuario> searchByUsername(String username) {
        return usuarioRepository.searchByUsername(username);
    }

    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = this.loadById(username);
        if (usuario == null) {
            LOGGER.error("Usuario no encontrado "+ username);
            throw new UsernameNotFoundException("El usuario no existe");
        }
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        LOGGER.info("Asignando permisos al usuario "+username);
        for (Rol rol : usuario.getRols()) {
            authorities.add(new SimpleGrantedAuthority(rol.getRolName().trim()));
            LOGGER.info("Granting rol: "+rol.getRolName());
        }
        return new User(usuario.getUsername().trim(), usuario.getPassword().trim(), authorities);
    }

    public boolean userExists(String username) {
        return loadById(username) == null ? false : true;
    }

}
