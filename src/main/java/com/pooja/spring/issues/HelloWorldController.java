package com.pooja.spring.issues;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    String index() {
        return "Hello Pooja!";
    }
}
