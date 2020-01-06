package com.flyingStone.backStage.web.controller;

import com.flyingStone.core.domain.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private JwtUtils jwtUtils;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, Model model) {
        return new ModelAndView("admin/login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(
//            @Validated @ModelAttribute JwtUser loginUser,
            HttpServletRequest request,
            HttpServletResponse response,
            BindingResult result) {

//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        jwtUtils.setJwtTokenToResponse(response,jwtUtils.generateToken(authentication));
    }

    @RequestMapping(value = "/denied", method = RequestMethod.GET)
    public ModelAndView denied(HttpServletRequest request, HttpServletResponse response, Model model) {
        return new ModelAndView("error/403");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response, Model model){
        return new ModelAndView("admin/register");
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> register(@Validated @ModelAttribute UserEntity userEntity,HttpServletRequest request, HttpServletResponse response, Model model){
        return null;
    }
}
