package org.inkasoft.edustat.controller.api;

import java.util.List;

import org.inkasoft.edustat.bean.TurnoBean;
import org.inkasoft.edustat.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TurnoApiController {
    @Autowired
    private TurnoService turnoService;
    
    @RequestMapping(value="/private/api/turno", method=RequestMethod.GET)
    @ResponseBody
    public List<TurnoBean> listAll () {
        return turnoService.listActive();
    }
}
