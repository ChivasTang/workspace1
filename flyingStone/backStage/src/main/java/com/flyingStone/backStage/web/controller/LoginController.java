package com.flyingStone.backStage.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @GetMapping("/signIn")
    public String signIn(@RequestParam(name="error",required=false)String error, @RequestParam(name="logout",required=false)String logout, ModelMap model){
        if (error != null) {
            model.put("error", "Username or password is not correct");
        } else if (logout != null) {
            model.put("logout", "Logout successful");
        }
        return "signIn";
    }

    @RequestMapping("/denied")
    @ResponseBody
    public String denied() {
        return "You have no permission to access the page";
    }
}
