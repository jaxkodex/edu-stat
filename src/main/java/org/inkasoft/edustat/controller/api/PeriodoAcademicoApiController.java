package org.inkasoft.edustat.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.inkasoft.edustat.bean.PeriodoAcademicoBean;
import org.inkasoft.edustat.model.PeriodoAcademico;
import org.inkasoft.edustat.model.Usuario;
import org.inkasoft.edustat.service.PeriodoAcademicoService;
import org.inkasoft.edustat.util.exceptions.PeriodoAcademicoAbiertoYaExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PeriodoAcademicoApiController {
    @Autowired
    private PeriodoAcademicoService periodoAcademicoService;

    @RequestMapping(value="/private/api/periodoacademico", method=RequestMethod.GET)
    @ResponseBody
    public List<PeriodoAcademicoBean> listAll (HttpServletRequest request) {
        HttpSession session;
        Usuario sessionUser;
        
        session = request.getSession();
        sessionUser = (Usuario) session.getAttribute("usuario");
        
        return periodoAcademicoService.listByInstitucionEducativa(sessionUser.getInstitucionEducativa().getIdIe());
    }
    
    @RequestMapping(value="/private/api/periodoacademico", method=RequestMethod.POST)
    @ResponseBody
    public PeriodoAcademicoBean create (@RequestBody PeriodoAcademico periodoAcademico) throws PeriodoAcademicoAbiertoYaExisteException {
        return periodoAcademicoService.aperturarPeriodoAcademico(periodoAcademico);
    }
    
    @ExceptionHandler(value=PeriodoAcademicoAbiertoYaExisteException.class)
    @ResponseStatus(value=HttpStatus.CONFLICT, reason="Periodo académico ya existe")
    public Map<String, Object> errorPeriodo (PeriodoAcademicoAbiertoYaExisteException ex) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", false);
        map.put("mensaje", ex.getMessage());
        return map;
    }
}
