package com.flyingStone.backStage.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyingStone.core.domain.common.RegisterDomain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
	
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




	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request,
								 HttpServletResponse response,
								 Model model){
		return new ModelAndView("admin/register");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public void register(@Validated @ModelAttribute RegisterDomain registerForm,
						 HttpServletRequest request,
						 HttpServletResponse response,
						 Model model){
		log.debug("Start loginController.");
		System.out.println(registerForm.toString());
	}
	
}
