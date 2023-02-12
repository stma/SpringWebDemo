package com.progmatic.springwebdemo.template;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class PropData {
    @GetMapping("/thymeleaf")
    public String homePage(Model model) {
        model.addAttribute("currentTime", LocalDateTime.now().toString());
        return "thymeleaf";
    }
}
