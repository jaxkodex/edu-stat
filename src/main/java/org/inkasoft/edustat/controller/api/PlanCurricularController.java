package org.inkasoft.edustat.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.inkasoft.edustat.bean.GradoBean;
import org.inkasoft.edustat.bean.NivelBean;
import org.inkasoft.edustat.model.Grado;
import org.inkasoft.edustat.model.Nivel;
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
	public @ResponseBody List<NivelBean> listNivel () {
		return planCurricularService.listAllNivel();
	}
	
	@RequestMapping(value={"/private/api/nivel/{idNivel}"}, method=RequestMethod.GET)
	public @ResponseBody NivelBean loadNivel (@PathVariable Integer idNivel) {
		return planCurricularService.loadNivelById(idNivel);
	}
	
	@RequestMapping(value={"/private/api/nivel"}, method=RequestMethod.POST)
	public @ResponseBody NivelBean createNivel (@RequestBody Nivel nivel) {
		return planCurricularService.createNivel(nivel);
	}
	
	@RequestMapping(value={"/private/api/nivel/{idNivel}"}, method=RequestMethod.PUT)
	public @ResponseBody NivelBean updateNivel (@RequestBody Nivel nivel) {
		return planCurricularService.updateNivel(nivel);
	}
	
	@RequestMapping(value={"/private/api/nivel/{idNivel}"}, method=RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> deleteNivel (@PathVariable Integer idNivel) {
		Map<String, Object> m = new HashMap<String, Object>();
		planCurricularService.deleteNivel(idNivel);
		m.put("success", true);
		return m;
	}
	
	@RequestMapping(value={"/private/api/grado"}, method=RequestMethod.GET)
	public @ResponseBody List<GradoBean> listGradoByNivel (@RequestParam(required=false) Integer idNivel) {
		if (idNivel == null) return planCurricularService.listAllGrado();
		return planCurricularService.listAllGrado(idNivel);
	}
	
	@RequestMapping(value={"/private/api/grado/{idGrado}"}, method=RequestMethod.GET)
	public @ResponseBody GradoBean loadGrado (@PathVariable Integer idGrado) {
		return planCurricularService.loadGradoById(idGrado);
	}
	
	@RequestMapping(value={"/private/api/grado"}, method=RequestMethod.POST)
	public @ResponseBody GradoBean createGrado (@RequestBody Grado grado) {
		return planCurricularService.createGrado(grado);
	}

	@RequestMapping(value={"/private/api/grado/{idGrado}"}, method=RequestMethod.PUT)
	public @ResponseBody GradoBean updateGrado (@RequestBody Grado grado) {
		return planCurricularService.updateGrado(grado);
	}

	@RequestMapping(value={"/private/api/grado/{idGrado}"}, method=RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> deleteGrado (@PathVariable Integer idGrado) {
		Map<String, Object> map = new HashMap<String, Object>();
		planCurricularService.deleteGrado(idGrado);
		map.put("success", true);
		return map;
	}

}
