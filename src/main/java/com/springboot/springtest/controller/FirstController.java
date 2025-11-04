package com.springboot.springtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/greetings")
    public String greetings(Model model) {
        model.addAttribute("nickname", "최영서");
        return "greetings";
    }

    @GetMapping("/goodbye")
    public String goodbye(Model model) {
        model.addAttribute("nickname", "최영서");
        return "goodbye";
    }
}

