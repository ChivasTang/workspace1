package com.flyingStone.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		log.debug("Main Start...");
		return new ModelAndView("main");
	}
	
//	@RequestMapping(value="/" , method=RequestMethod.GET)
//	public String main(HttpServletRequest request, HttpServletResponse response, Model model) {
//		logger.debug("Main Start...");
//		List<EmployeeEntity> employees=employeeDao.selectAll();
//		model.addAttribute("employees", employees);
//		model.addAttribute("msg", "Hello World...");
//
//		return "main";
//	}
}
