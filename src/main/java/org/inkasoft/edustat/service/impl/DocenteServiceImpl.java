package org.inkasoft.edustat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.inkasoft.edustat.bean.DocenteBean;
import org.inkasoft.edustat.bean.PersonaBean;
import org.inkasoft.edustat.model.Docente;
import org.inkasoft.edustat.model.InstitucionEducativaHasDocente;
import org.inkasoft.edustat.model.InstitucionEducativaHasDocentePK;
import org.inkasoft.edustat.model.Usuario;
import org.inkasoft.edustat.repository.DocenteHasInsitucionEducativaRepository;
import org.inkasoft.edustat.repository.DocenteRepository;
import org.inkasoft.edustat.repository.PersonaRepository;
import org.inkasoft.edustat.repository.UsuarioRepository;
import org.inkasoft.edustat.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceImpl implements DocenteService {
	private static final Logger LOGGER = Logger.getLogger(DocenteServiceImpl.class);
    @Autowired DocenteRepository docenteRepository;
    @Autowired UsuarioRepository usuarioRepository;
    @Autowired PersonaRepository personaRepository;
    @Autowired DocenteHasInsitucionEducativaRepository docenteHasInsitucionEducativaRepository;

    public DocenteBean create(Docente docente) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario usuario = usuarioRepository.findOne(username);
        List<Docente> docentes;
        Docente docenteG = null;
        
        LOGGER.info("Saving persona data for "+docente.getPersona().getPersonaDni());
        personaRepository.save(docente.getPersona());
        docentes = docenteRepository.findByPersonaPersonaDni(docente.getPersona().getPersonaDni());
        if (!docentes.isEmpty()) {
        	// Ya existe el docente registrado en el sistema, actualizar su información
        	docenteG = docentes.get(0);
        	docenteG.setPersona(docente.getPersona());
        } else {
        	// Crea uno nuevo
        	docenteG = docente;
        }
        docenteRepository.save(docenteG);
        
        InstitucionEducativaHasDocente iehd = new InstitucionEducativaHasDocente();
        InstitucionEducativaHasDocentePK pk = new InstitucionEducativaHasDocentePK();
        pk.setDocenteIdDocente(docenteG.getIdDocente());
        pk.setInstitucionEducativaIdIe(usuario.getInstitucionEducativa().getIdIe());
        iehd.setId(pk);
        iehd.setDocente(docenteG);
        iehd.setInstitucionEducativa(usuario.getInstitucionEducativa());
        iehd.setEsDirector((byte) 0);
        docenteHasInsitucionEducativaRepository.save(iehd);
        
        
        DocenteBean docenteBean;
        docenteBean = DocenteBean.transformToBean(docente);
        docenteBean.setPersona(PersonaBean.transformToBean(docente.getPersona()));
        return docenteBean;
    }

    public DocenteBean loadById(Integer id) {
        Docente docente = docenteRepository.findOne(id);
        
        DocenteBean docenteBean;
        
        docenteBean = DocenteBean.transformToBean(docente);
        docenteBean.setPersona(PersonaBean.transformToBean(docente.getPersona()));
        
        return docenteBean;
    }

    public List<DocenteBean> findAll() {
        List<Docente> docentes = docenteRepository.findAll();
        List<DocenteBean> docenteBeans = new ArrayList<DocenteBean>();
        
        for (Docente docente : docentes) {
            DocenteBean docenteBean;
            docenteBean = DocenteBean.transformToBean(docente);
            docenteBean.setPersona(PersonaBean.transformToBean(docente.getPersona()));
            
            docenteBeans.add(docenteBean);
        }
        
        return docenteBeans;
    }

    public DocenteBean update(Docente docente) {
        docenteRepository.save(docente);
        DocenteBean docenteBean;
        docenteBean = DocenteBean.transformToBean(docente);
        docenteBean.setPersona(PersonaBean.transformToBean(docente.getPersona()));
        return docenteBean;
    }

    public void delete(Integer id) {
        docenteRepository.delete(id);
    }

    public List<DocenteBean> findAllByIe(Integer idIe) {
        List<Docente> docentes = docenteRepository.findByInstitucionEducativaHasDocentesInstitucionEducativaIdIe(idIe);
        List<DocenteBean> docenteBeans = new ArrayList<DocenteBean>();
        
        for (Docente docente : docentes) {        
            DocenteBean docenteBean;
            docenteBean = DocenteBean.transformToBean(docente);
            docenteBean.setPersona(PersonaBean.transformToBean(docente.getPersona()));
            
            docenteBeans.add(docenteBean);
        }
        
        return docenteBeans;
    }

}
