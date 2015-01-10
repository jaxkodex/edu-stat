package org.inkasoft.edustat.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private static final Logger LOGGER = Logger.getLogger(MainController.class);

    @RequestMapping(value={"/", "index.do"})
    public String index () {
    	LOGGER.debug("Entrando a index");
        return "index";
    }

    @RequestMapping(value={"isearchtest.do"})
    public String isearchtest () {
        return "isearchtest";
    }

}
