package com.PJR.Quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")
public class MainController {

    @GetMapping("")
    public String index() {return "index";}

    @GetMapping("/loginForm")
    public String login() {return "loginForm";}
}
