package org.inkasoft.edustat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.inkasoft.edustat.bean.DocenteBean;
import org.inkasoft.edustat.bean.PersonaBean;
import org.inkasoft.edustat.model.Docente;
import org.inkasoft.edustat.repository.DocenteRepository;
import org.inkasoft.edustat.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceImpl implements DocenteService {
	@Autowired DocenteRepository docenteRepository;

	public DocenteBean create(Docente docente) throws Exception {
		docenteRepository.save(docente);
		DocenteBean docenteBean = new DocenteBean();
		
		docenteBean.setIdDocente(docente.getIdDocente());
		
		PersonaBean personaBean = new PersonaBean();
		personaBean.setPersonaDni(docente.getPersona().getPersonaDni());
		personaBean.setPersonaApaterno(docente.getPersona().getPersonaApaterno());
		personaBean.setPersonaAmaterno(docente.getPersona().getPersonaAmaterno());
		personaBean.setPersonaPnombre(docente.getPersona().getPersonaPnombre());
		personaBean.setPersonaSnombre(docente.getPersona().getPersonaSnombre());
		
		docenteBean.setPersona(personaBean);
		return docenteBean;
	}

	public DocenteBean loadById(Integer id) {
		Docente docente = docenteRepository.findOne(id);
		DocenteBean docenteBean = new DocenteBean();
		
		docenteBean.setIdDocente(docente.getIdDocente());
		
		PersonaBean personaBean = new PersonaBean();
		personaBean.setPersonaDni(docente.getPersona().getPersonaDni());
		personaBean.setPersonaApaterno(docente.getPersona().getPersonaApaterno());
		personaBean.setPersonaAmaterno(docente.getPersona().getPersonaAmaterno());
		personaBean.setPersonaPnombre(docente.getPersona().getPersonaPnombre());
		personaBean.setPersonaSnombre(docente.getPersona().getPersonaSnombre());
		
		docenteBean.setPersona(personaBean);
		return docenteBean;
	}

	public List<DocenteBean> findAll() {
		List<Docente> docentes = docenteRepository.findAll();
		List<DocenteBean> docenteBeans = new ArrayList<DocenteBean>();
		
		for (Docente docente : docentes) {
			DocenteBean docenteBean = new DocenteBean();
			
			docenteBean.setIdDocente(docente.getIdDocente());
			
			PersonaBean personaBean = new PersonaBean();
			personaBean.setPersonaDni(docente.getPersona().getPersonaDni());
			personaBean.setPersonaApaterno(docente.getPersona().getPersonaApaterno());
			personaBean.setPersonaAmaterno(docente.getPersona().getPersonaAmaterno());
			personaBean.setPersonaPnombre(docente.getPersona().getPersonaPnombre());
			personaBean.setPersonaSnombre(docente.getPersona().getPersonaSnombre());
			
			docenteBean.setPersona(personaBean);
			
			docenteBeans.add(docenteBean);
		}
		
		return docenteBeans;
	}

	public DocenteBean update(Docente docente) throws Exception {
		docenteRepository.save(docente);
		DocenteBean docenteBean = new DocenteBean();
		
		docenteBean.setIdDocente(docente.getIdDocente());
		
		PersonaBean personaBean = new PersonaBean();
		personaBean.setPersonaDni(docente.getPersona().getPersonaDni());
		personaBean.setPersonaApaterno(docente.getPersona().getPersonaApaterno());
		personaBean.setPersonaAmaterno(docente.getPersona().getPersonaAmaterno());
		personaBean.setPersonaPnombre(docente.getPersona().getPersonaPnombre());
		personaBean.setPersonaSnombre(docente.getPersona().getPersonaSnombre());
		
		docenteBean.setPersona(personaBean);
		return docenteBean;
	}

	public void delete(Integer id) {
		docenteRepository.delete(id);
	}

	public List<DocenteBean> findAllByIe(Integer idIe) {
		List<Docente> docentes = docenteRepository.findByInstitucionEducativaHasDocentesInstitucionEducativaIdIe(idIe);
		List<DocenteBean> docenteBeans = new ArrayList<DocenteBean>();
		
		for (Docente docente : docentes) {
			DocenteBean docenteBean = new DocenteBean();
			
			docenteBean.setIdDocente(docente.getIdDocente());
			
			PersonaBean personaBean = new PersonaBean();
			personaBean.setPersonaDni(docente.getPersona().getPersonaDni());
			personaBean.setPersonaApaterno(docente.getPersona().getPersonaApaterno());
			personaBean.setPersonaAmaterno(docente.getPersona().getPersonaAmaterno());
			personaBean.setPersonaPnombre(docente.getPersona().getPersonaPnombre());
			personaBean.setPersonaSnombre(docente.getPersona().getPersonaSnombre());
			
			docenteBean.setPersona(personaBean);
			
			docenteBeans.add(docenteBean);
		}
		
		return docenteBeans;
	}

}
