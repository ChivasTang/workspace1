package com.flyingStone.backStage.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    @GetMapping("/signIn")
    public ModelAndView signIn(@RequestParam(name="error",required=false)String error, @RequestParam(name="logout",required=false)String logout, ModelMap model){
    	ModelAndView mv=new ModelAndView("signIn");
        if (error != null) {
        	mv.addObject("error", "Username or password is not correct");
        } else if (logout != null) {
        	mv.addObject("logout", "Logout successful");
        }
        return mv;
    }

    @RequestMapping("/denied")
    @ResponseBody
    public String denied() {
        return "You have no permission to access the page";
    }
}
