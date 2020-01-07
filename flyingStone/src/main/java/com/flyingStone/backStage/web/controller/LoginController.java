package com.flyingStone.backStage.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/admin")
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
							  @RequestParam(value = "logout", required = false) String logout,
							  HttpServletRequest request,
							  HttpServletResponse response,
							  Model model) {
		log.debug("Start loginController.");
		ModelAndView mv=new ModelAndView("admin/login");

		if (error != null) {
			mv.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			mv.addObject("msg", "You've been logged out successfully.");
		}

		return mv;
	}
	
}
