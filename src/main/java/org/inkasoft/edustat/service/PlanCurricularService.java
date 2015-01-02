package org.inkasoft.edustat.service;

import java.util.List;

import org.inkasoft.edustat.bean.GradoBean;
import org.inkasoft.edustat.bean.NivelBean;
import org.inkasoft.edustat.bean.SeccionBean;
import org.inkasoft.edustat.model.Grado;
import org.inkasoft.edustat.model.Nivel;
import org.inkasoft.edustat.model.Seccion;

public interface PlanCurricularService {

    public List<NivelBean> listAllNivel();

    public List<GradoBean> listAllGrado();

    public List<GradoBean> listAllGrado(Integer idNivel);

    public List<SeccionBean> listAllSeccion();

    public List<SeccionBean> listAllSeccion(Integer idGrado);

    public NivelBean loadNivelById(Integer idNivel);

    public GradoBean loadGradoById(Integer idGrado);

    public SeccionBean loadSeccionById(Integer idSeccion);

    public NivelBean createNivel(Nivel nivel);

    public GradoBean createGrado(Grado grado);

    public SeccionBean createSeccion(Seccion seccion);

    public NivelBean updateNivel(Nivel nivel);

    public GradoBean updateGrado(Grado grado);

    public SeccionBean updateSeccion(Seccion seccion);

    public void deleteNivel(Integer idNivel);

    public void deleteGrado(Integer idGrado);

    public void deleteSeccion(Integer idSeccion);
}
