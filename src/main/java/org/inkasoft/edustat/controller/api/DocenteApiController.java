package org.inkasoft.edustat.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.inkasoft.edustat.bean.DocenteBean;
import org.inkasoft.edustat.model.Docente;
import org.inkasoft.edustat.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DocenteApiController {

	@Autowired DocenteService docenteService;

	/*@RequestMapping(value={"/public/api/docente"}, method=RequestMethod.GET)
	public List<DocenteBean> listAllDocentes () {
		return docenteService.findAll();
	}*/

	@RequestMapping(value={"/private/api/docente"}, method=RequestMethod.GET)
	public @ResponseBody List<DocenteBean> listAllDocentesByIe (@RequestParam Integer idIe) {
		return docenteService.findAllByIe(idIe);
	}
	
	@RequestMapping(value={"/private/api/docente/{idDocente}"}, method=RequestMethod.GET)
	public @ResponseBody DocenteBean loadDocente (@PathVariable Integer idDocente) {
		return docenteService.loadById(idDocente);
	}
	
	@RequestMapping(value={"/private/api/docente"}, method=RequestMethod.POST)
	public @ResponseBody DocenteBean create (@RequestBody Docente docente) throws Exception {
		return docenteService.create(docente);
	}
	
	@RequestMapping(value={"/private/api/docente"}, method=RequestMethod.PUT)
	public @ResponseBody DocenteBean update (@RequestBody Docente docente) throws Exception {
		return docenteService.update(docente);
	}
	
	@RequestMapping(value={"/private/api/docente/{idDocente}"}, method=RequestMethod.DELETE)
	public @ResponseBody Map<String, Object> delete (@PathVariable Integer idDocente) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		docenteService.delete(idDocente);
		return map;
	}
}
