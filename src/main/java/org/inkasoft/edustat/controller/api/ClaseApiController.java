package org.inkasoft.edustat.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.inkasoft.edustat.bean.ClaseBean;
import org.inkasoft.edustat.model.Clase;
import org.inkasoft.edustat.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClaseApiController {
	@Autowired
	private ClaseService claseService;

	@RequestMapping(value="/private/api/clase", method=RequestMethod.GET)
	@ResponseBody
	public List<ClaseBean> listClases (@RequestParam(required=false) Integer idPeriodo,
	        @RequestParam(required=false) Integer idNivel,
	        @RequestParam(required=false) Integer idTurno) {
	    
	    if (idPeriodo != null && idNivel != null && idTurno != null) {
	        return claseService.cargarClasesPorPeriodoTurnoNivel(idPeriodo, idNivel, idTurno);
	    }
	    
		if (idPeriodo == null) {
			return new ArrayList<ClaseBean>();
		}
		return claseService.cargarClasesPorPeriodo(idPeriodo);
	}
	
	@RequestMapping(value="/private/api/clase/{idClase}", method = RequestMethod.GET)
	@ResponseBody
	public ClaseBean loadClase (@PathVariable Integer idClase) {
	    return claseService.loadClase(idClase);
	}

	@RequestMapping(value="/private/api/clase", method=RequestMethod.PUT)
	@ResponseBody
	public ClaseBean updateClase (@RequestBody Clase clase) {
		return claseService.actualizarClase(clase);
	}
}
