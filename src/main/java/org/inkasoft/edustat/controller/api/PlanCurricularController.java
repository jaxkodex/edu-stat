package org.inkasoft.edustat.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.inkasoft.edustat.bean.GradoBean;
import org.inkasoft.edustat.bean.NivelBean;
import org.inkasoft.edustat.bean.SeccionBean;
import org.inkasoft.edustat.model.Grado;
import org.inkasoft.edustat.model.Nivel;
import org.inkasoft.edustat.model.Seccion;
import org.inkasoft.edustat.service.PlanCurricularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PlanCurricularController {
    @Autowired PlanCurricularService planCurricularService;
    
    @RequestMapping(value={"/private/api/nivel"}, method=RequestMethod.GET)
    @ResponseBody
    public List<NivelBean> listNivel () {
        return planCurricularService.listAllNivel();
    }
    
    @RequestMapping(value={"/private/api/nivel/{idNivel}"}, method=RequestMethod.GET)
    @ResponseBody
    public NivelBean loadNivel (@PathVariable Integer idNivel) {
        return planCurricularService.loadNivelById(idNivel);
    }
    
    @RequestMapping(value={"/private/api/nivel"}, method=RequestMethod.POST)
    @ResponseBody
    public NivelBean createNivel (@RequestBody Nivel nivel) {
        return planCurricularService.createNivel(nivel);
    }
    
    @RequestMapping(value={"/private/api/nivel/{idNivel}"}, method=RequestMethod.PUT)
    @ResponseBody
    public NivelBean updateNivel (@RequestBody Nivel nivel) {
        return planCurricularService.updateNivel(nivel);
    }
    
    @RequestMapping(value={"/private/api/nivel/{idNivel}"}, method=RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteNivel (@PathVariable Integer idNivel) {
        Map<String, Object> m = new HashMap<String, Object>();
        planCurricularService.deleteNivel(idNivel);
        m.put("success", true);
        return m;
    }
    
    @RequestMapping(value={"/private/api/grado"}, method=RequestMethod.GET)
    @ResponseBody
    public List<GradoBean> listGradoByNivel (@RequestParam(required=false) Integer idNivel) {
        if (idNivel == null) {
            return planCurricularService.listAllGrado();
        }
        return planCurricularService.listAllGrado(idNivel);
    }
    
    @RequestMapping(value={"/private/api/grado/{idGrado}"}, method=RequestMethod.GET)
    @ResponseBody
    public GradoBean loadGrado (@PathVariable Integer idGrado) {
        return planCurricularService.loadGradoById(idGrado);
    }
    
    @RequestMapping(value={"/private/api/grado"}, method=RequestMethod.POST)
    @ResponseBody
    public GradoBean createGrado (@RequestBody Grado grado) {
        return planCurricularService.createGrado(grado);
    }

    @RequestMapping(value={"/private/api/grado/{idGrado}"}, method=RequestMethod.PUT)
    @ResponseBody
    public GradoBean updateGrado (@RequestBody Grado grado) {
        return planCurricularService.updateGrado(grado);
    }

    @RequestMapping(value={"/private/api/grado/{idGrado}"}, method=RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteGrado (@PathVariable Integer idGrado) {
        Map<String, Object> map = new HashMap<String, Object>();
        planCurricularService.deleteGrado(idGrado);
        map.put("success", true);
        return map;
    }
    
    @RequestMapping(value={"/private/api/seccion"}, method=RequestMethod.GET)
    @ResponseBody
    public List<SeccionBean> listSecciones (@RequestParam Integer idGrado) {
    	if (idGrado == null) {
    		return planCurricularService.listAllSeccion();
    	}
        return planCurricularService.listAllSeccion(idGrado);
    }
    
    @RequestMapping(value={"/private/api/seccion/{idSeccion}"}, method=RequestMethod.GET)
    @ResponseBody
    public SeccionBean getOneSeccion (@PathVariable Integer idSeccion) {
        return planCurricularService.loadSeccionById(idSeccion);
    }
    
    @RequestMapping(value={"/private/api/seccion"}, method=RequestMethod.POST)
    @ResponseBody
    public SeccionBean createSeccion (@RequestBody Seccion seccion) {
        return planCurricularService.createSeccion(seccion);
    }
    
    @RequestMapping(value={"/private/api/seccion/{idSeccion}"}, method=RequestMethod.PUT)
    @ResponseBody
    public SeccionBean updateSeccion (@RequestBody Seccion seccion) {
        return planCurricularService.updateSeccion(seccion);
    }
    
    @RequestMapping(value={"/private/api/seccion/{idSeccion}"}, method=RequestMethod.DELETE)
    @ResponseBody
    public String deleteSeccion (@PathVariable Integer idSeccion) {
        planCurricularService.deleteSeccion(idSeccion);
        return "OK";
    }
}
