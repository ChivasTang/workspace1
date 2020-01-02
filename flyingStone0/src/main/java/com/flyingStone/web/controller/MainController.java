package com.flyingStone.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.flyingStone.core.dao.EmployeeDao;
import com.flyingStone.core.domain.entity.EmployeeEntity;

@Controller
public class MainController {
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@RequestMapping(value="/" , method=RequestMethod.GET)
	public ModelAndView main(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("Main Start...");
		ModelAndView mv=new ModelAndView("main");
		List<EmployeeEntity> employees=employeeDao.selectAll();
		for(EmployeeEntity employee: employees) {
			logger.debug(employee.toString());
		}
		mv.addObject("employees", employees);
		mv.addObject("msg", "Hello World...");
		return mv;
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
