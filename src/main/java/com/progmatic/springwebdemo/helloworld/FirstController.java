package com.progmatic.springwebdemo.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class FirstController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello(
            @Value("${hello.name}") String name,
            @Value("${hello.number}") Integer num
    ) {
        return String.format("Hello %s(%.0f)!", name, Math.floor(num * Math.random()));
    }
}
