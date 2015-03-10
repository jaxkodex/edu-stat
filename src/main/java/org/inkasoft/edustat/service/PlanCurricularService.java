package org.inkasoft.edustat.service;

import java.util.List;

import org.inkasoft.edustat.bean.GradoBean;
import org.inkasoft.edustat.bean.NivelBean;
import org.inkasoft.edustat.bean.SeccionBean;
import org.inkasoft.edustat.model.Grado;
import org.inkasoft.edustat.model.Nivel;
import org.inkasoft.edustat.model.Seccion;

public interface PlanCurricularService {

    // Para Niveles
    public List<NivelBean> listAllNivel();
    public NivelBean loadNivelById(Integer idNivel);
    public NivelBean createNivel(Nivel nivel);
    public NivelBean updateNivel(Nivel nivel);
    public void deleteNivel(Integer idNivel);
    
    // Para Grado
    public List<GradoBean> listAllGrado();
    public List<GradoBean> listAllGrado(Integer idNivel);
    public GradoBean loadGradoById(Integer idGrado);
    public GradoBean createGrado(Grado grado);
    public GradoBean updateGrado(Grado grado);
    public void deleteGrado(Integer idGrado);
    
    // Para secciones
    public List<SeccionBean> listAllSeccion();
    public List<SeccionBean> listAllActiveSeccion();
    public List<SeccionBean> listAllSeccion(Integer idGrado);
    public SeccionBean loadSeccionById(Integer idSeccion);
    public SeccionBean createSeccion(Seccion seccion);
    public SeccionBean updateSeccion(Seccion seccion);
    public void deleteSeccion(Integer idSeccion);
}
