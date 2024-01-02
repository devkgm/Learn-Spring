package com.devkgm.app.countries;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@RequestMapping(value = "/countries/*")
public class CountryController {
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) {
		return "/countries/list";
	}
}
