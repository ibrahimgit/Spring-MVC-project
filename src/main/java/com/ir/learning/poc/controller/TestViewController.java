package com.ir.learning.poc.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestViewController {
	
	private static final Logger LOGGER = Logger.getLogger(TestViewController.class);
	
	@RequestMapping("/hw")
	public String helloWorld() {
		return "Home";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	   public String printHello(ModelMap model) {
	      model.addAttribute("message", "Hello Spring MVC Framework!");
	      return "Home";
	   }
	
	@RequestMapping(value = "/xsstest", method = RequestMethod.POST)
	   public String testXSS(ModelMap model, @RequestParam("test") String xss) {
		LOGGER.debug("testXSS: " + xss);
	      model.addAttribute("message", xss);
	      return "xss";
	   }


}
