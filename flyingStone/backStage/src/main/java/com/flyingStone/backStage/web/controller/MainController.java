package com.flyingStone.backStage.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class MainController {

    // ログを設定
    private Logger logger= LoggerFactory.getLogger(getClass());

    @GetMapping
    public ModelAndView main(HttpServletRequest request, HttpServletResponse response, Model model){
        logger.info("main ...");
        return new ModelAndView("main");
    }
}
