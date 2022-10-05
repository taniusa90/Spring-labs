package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("/login/{email}/{phoneNumber}")

    public String loginPage(@PathVariable String email, @PathVariable String phoneNumber, Model model){

       model.addAttribute("email",email);
       model.addAttribute("phoneNumber",phoneNumber);
       String message = "Login Successful";
       model.addAttribute("loginMessage",message);


        return "login/login-info";
    }
}
