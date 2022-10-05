package com.cydeo.controller;

import com.cydeo.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String profilePage(Model model){

        Profile profile = new Profile();
        profile.setName("mike");
        profile.setSurname("smith");
        profile.setPhoneNumber("+1256342345");
        profile.setEmail("msmith@gmail.com");
        profile.setCreatedDate(LocalDateTime.now());

        model.addAttribute("profile",profile);

        return "profile/profile.html";
    }
}
