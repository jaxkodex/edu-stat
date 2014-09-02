package org.inkasoft.edustat.controller.api;

import java.util.List;

import org.inkasoft.edustat.model.InstitucionEducativa;
import org.inkasoft.edustat.service.InstitucionEducativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class InstitucionEducativaApiController {
	@Autowired InstitucionEducativaService institucionEducativaService;
	
	@RequestMapping(value="/public/api/institucioneducativa", method=RequestMethod.GET)
	@ResponseBody
	public List<InstitucionEducativa> list () {
		return institucionEducativaService.findAll();
	}
	
	@RequestMapping(value="/private/api/institucioneducativa", method=RequestMethod.POST)
	@ResponseBody
	public InstitucionEducativa create (@RequestBody InstitucionEducativa institucionEducativa) throws Exception {
		return institucionEducativaService.create(institucionEducativa);
	}
	
	@RequestMapping(value="/public/api/institucioneducativa/{idInstitucionEducativa}", method=RequestMethod.GET)
	@ResponseBody
	public InstitucionEducativa load (@PathVariable Integer idInstitucionEducativa) {
		return institucionEducativaService.loadById(idInstitucionEducativa);
	}

}
