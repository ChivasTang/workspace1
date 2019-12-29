package com.flyingStone.backStage.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")
public class LoginController {
    // ログを設定
    private Logger logger= LoggerFactory.getLogger(getClass());

    @RequestMapping(value="login",method= RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request,
                              HttpServletResponse response,
                              @RequestParam(name="error",required=false)String error,
                              @RequestParam(name="logout",required=false)String logout,
                              Model model){
        logger.info("login get...");
        ModelAndView mv = new ModelAndView("admin/login");
        mv.addObject("title","login");
        if(error!=null){
            mv.addObject("error", "Invalid username or password.");
        }
        if(logout!=null){
            mv.addObject("msg", "You've been logged out successfully.");
        }
        return mv;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(HttpServletRequest request,
                      HttpServletResponse response,
                      Model model){
        System.out.println("login post...");
    }
}
