package com.flyingStone.backStage.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flyingStone.core.domain.common.RegisterDomain;
import com.flyingStone.security.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	@Autowired
	private UserService userService;
	
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
	public ModelAndView register(@ModelAttribute("registerForm") RegisterDomain registerForm,
						 HttpServletRequest request,
						 HttpServletResponse response){
		log.debug("Start loginController.");
		if(registerForm ==null){
			log.error("ユーザ登録情報を入力ください。");
			return new ModelAndView("admin/register");
		}
		if(StringUtils.isEmpty(registerForm.getUsername())){
			log.error("ユーザ名を入力ください。");
			return new ModelAndView("admin/register");
		}
		if(StringUtils.isEmpty(registerForm.getPassword())){
			log.error("パスワードを入力ください。");
			return new ModelAndView("admin/register");
		}
		if(StringUtils.isEmpty(registerForm.getConfirmPassword())){
			log.error("パスワードを再度入力ください。");
			return new ModelAndView("admin/register");
		}
		if(StringUtils.isEmpty(registerForm.getEmail())){
			log.error("Emailを入力ください。");
			return new ModelAndView("admin/register");
		}
		if(!registerForm.getPassword().equals(registerForm.getConfirmPassword())){
			log.error("パースワードは同じではないです。");
			return new ModelAndView("admin/register");
		}
		if(!userService.registerUser(registerForm)){
			return new ModelAndView("admin/register");
		}
		return new ModelAndView("admin/login");
	}
}
