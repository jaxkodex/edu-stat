package org.inkasoft.edustat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value={"/", "index.do"})
	public String index () {
		return "index";
	}

	@RequestMapping(value={"isearchtest.do"})
	public String isearchtest () {
		return "isearchtest";
	}

}
