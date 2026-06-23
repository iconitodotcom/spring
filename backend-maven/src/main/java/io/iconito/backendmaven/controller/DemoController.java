package io.iconito.backendmaven.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // Test URL : http://127.0.0.1:8080/home
//    @GetMapping("/home")
//    @RequestMapping("/home")
    @RequestMapping(path = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    // consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayHellow(){ return "Hello World!"; }
}
