package com.flyingStone.backStage.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class LoginController {
	@RequestMapping(value = "/login", method=RequestMethod.GET)
    public ModelAndView signIn(@RequestParam(name="error",required=false)String error, @RequestParam(name="logout",required=false)String logout, ModelMap model){
    	ModelAndView mv=new ModelAndView("admin/login");
        if (error != null) {
        	mv.addObject("error", "Username or password is not correct");
        } else if (logout != null) {
        	mv.addObject("logout", "Logout successful");
        }
        return mv;
    }

	@RequestMapping(value = "/denied", method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView denied() {
        ModelAndView mv=new ModelAndView("admin/denied");
        mv.addObject("msg","You have no permission to access the page");
        return mv;
    }
}
