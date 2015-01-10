package org.inkasoft.edustat.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	public Logger logger = Logger.getLogger(MainController.class);

	@RequestMapping(value={"/", "index.do"})
	public String index () {
		logger.debug("Entrando a Index "+new Date());
		return "index";
	}

	@RequestMapping(value={"isearchtest.do"})
	public String isearchtest () {
		return "isearchtest";
	}

}
