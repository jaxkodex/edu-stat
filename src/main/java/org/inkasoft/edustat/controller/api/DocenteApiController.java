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

    @RequestMapping(value={"/private/api/docente"}, method=RequestMethod.GET)
    @ResponseBody
    public List<DocenteBean> listAllDocentesByIe (@RequestParam Integer idIe) {
        return docenteService.findAllByIe(idIe);
    }
    
    @RequestMapping(value={"/private/api/docente/{idDocente}"}, method=RequestMethod.GET)
    @ResponseBody
    public DocenteBean loadDocente (@PathVariable Integer idDocente) {
        return docenteService.loadById(idDocente);
    }
    
    @RequestMapping(value={"/private/api/docente"}, method=RequestMethod.POST)
    @ResponseBody
    public DocenteBean create (@RequestBody Docente docente) {
        return docenteService.create(docente);
    }
    
    @RequestMapping(value={"/private/api/docente"}, method=RequestMethod.PUT)
    @ResponseBody
    public DocenteBean update (@RequestBody Docente docente) {
        return docenteService.update(docente);
    }
    
    @RequestMapping(value={"/private/api/docente/{idDocente}"}, method=RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> delete (@PathVariable Integer idDocente) {
        Map<String, Object> map = new HashMap<String, Object>();
        docenteService.delete(idDocente);
        return map;
    }
}
