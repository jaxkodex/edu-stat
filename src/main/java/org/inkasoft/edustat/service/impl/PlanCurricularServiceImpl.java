package org.inkasoft.edustat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.inkasoft.edustat.bean.GradoBean;
import org.inkasoft.edustat.bean.NivelBean;
import org.inkasoft.edustat.bean.SeccionBean;
import org.inkasoft.edustat.model.Grado;
import org.inkasoft.edustat.model.Nivel;
import org.inkasoft.edustat.model.Seccion;
import org.inkasoft.edustat.repository.GradoRepository;
import org.inkasoft.edustat.repository.NivelRepository;
import org.inkasoft.edustat.repository.SeccionRepository;
import org.inkasoft.edustat.service.PlanCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanCurricularServiceImpl implements PlanCurricularService {
    @Autowired
    NivelRepository nivelRepository;
    @Autowired
    GradoRepository gradoRepository;
    @Autowired
    SeccionRepository seccionRepository;

    public List<NivelBean> listAllNivel() {
        List<NivelBean> nivelBeans;
        List<Nivel> niveles = nivelRepository.findAll();

        nivelBeans = new ArrayList<NivelBean>();

        for (Nivel nivel : niveles) {
            nivelBeans.add(NivelBean.transformToBean(nivel));
        }

        return nivelBeans;
    }

    public List<GradoBean> listAllGrado() {
        List<GradoBean> gradoBeans;
        List<Grado> grados;
        grados = gradoRepository.findAll();
        gradoBeans = new ArrayList<GradoBean>();
        for (Grado grado : grados) {
            gradoBeans.add(GradoBean.transformToBean(grado));
        }
        return gradoBeans;
    }

    public List<SeccionBean> listAllSeccion() {
        List<SeccionBean> seccionBeans;
        List<Seccion> secciones;
        seccionBeans = new ArrayList<SeccionBean>();
        secciones = seccionRepository.findAll();
        for (Seccion seccion : secciones) {
            seccionBeans.add(SeccionBean.transformToBean(seccion));
        }
        return seccionBeans;
    }

    public NivelBean loadNivelById(Integer idNivel) {
        Nivel nivel;
        nivel = nivelRepository.findOne(idNivel);
        return NivelBean.transformToBean(nivel);
    }

    public GradoBean loadGradoById(Integer idGrado) {
        Grado grado;
        grado = gradoRepository.findOne(idGrado);
        return GradoBean.transformToBean(grado);
    }

    public SeccionBean loadSeccionById(Integer idSeccion) {
        Seccion seccion;
        seccion = seccionRepository.findOne(idSeccion);
        return SeccionBean.transformToBean(seccion);
    }

    public NivelBean createNivel(Nivel nivel) {
        return NivelBean.transformToBean(nivelRepository.save(nivel));
    }

    public GradoBean createGrado(Grado grado) {
        return GradoBean.transformToBean(gradoRepository.save(grado));
    }

    public SeccionBean createSeccion(Seccion seccion) {
        return SeccionBean.transformToBean(seccionRepository.save(seccion));
    }

    public NivelBean updateNivel(Nivel nivel) {
        return NivelBean.transformToBean(nivelRepository.save(nivel));
    }

    public GradoBean updateGrado(Grado grado) {
        return GradoBean.transformToBean(gradoRepository.save(grado));
    }

    public SeccionBean updateSeccion(Seccion seccion) {
        return SeccionBean.transformToBean(seccionRepository.save(seccion));
    }

    public void deleteNivel(Integer idNivel) {
        nivelRepository.delete(idNivel);
    }

    public void deleteGrado(Integer idGrado) {
        gradoRepository.delete(idGrado);
    }

    public void deleteSeccion(Integer idSeccion) {
        seccionRepository.delete(idSeccion);
    }

    public List<GradoBean> listAllGrado(Integer idNivel) {
        List<GradoBean> gradoBeans;
        List<Grado> grados;
        grados = gradoRepository.findByNivelIdNivel(idNivel);
        gradoBeans = new ArrayList<GradoBean>();
        for (Grado grado : grados) {
            gradoBeans.add(GradoBean.transformToBean(grado));
        }
        return gradoBeans;
    }

    public List<SeccionBean> listAllSeccion(Integer idGrado) {
        List<SeccionBean> seccionBeans;
        List<Seccion> secciones;
        seccionBeans = new ArrayList<SeccionBean>();
        secciones = seccionRepository.findByGradoIdGrado(idGrado);
        for (Seccion seccion : secciones) {
            seccionBeans.add(SeccionBean.transformToBean(seccion));
        }
        return seccionBeans;
    }

}
