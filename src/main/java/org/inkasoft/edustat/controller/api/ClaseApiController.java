package org.inkasoft.edustat.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.inkasoft.edustat.bean.ClaseBean;
import org.inkasoft.edustat.model.Clase;
import org.inkasoft.edustat.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public List<ClaseBean> listClases (@RequestParam(required=false) Integer idPeriodo) {
		if (idPeriodo == null) {
			return new ArrayList<ClaseBean>();
		}
		return claseService.cargarClasesPorPeriodo(idPeriodo);
	}

	@RequestMapping(value="/private/api/clase", method=RequestMethod.PUT)
	@ResponseBody
	public ClaseBean updateClase (@RequestBody Clase clase) {
		return claseService.actualizarClase(clase);
	}
}
