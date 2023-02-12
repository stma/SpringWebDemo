package com.progmatic.springwebdemo.statikus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class St {

    @GetMapping("/st/one")
    public String one() {
        return "redirect:/one.html";
    }

    @GetMapping("/st2/one")
    public String one2() {
        return "one";
    }

    @GetMapping("/st/two")
    public String two() {
        return "/static/two.html";
    }
}
