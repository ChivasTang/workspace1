package com.flyingStone.backStage.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,Model model){
        return new ModelAndView("admin/login");
    }

}
