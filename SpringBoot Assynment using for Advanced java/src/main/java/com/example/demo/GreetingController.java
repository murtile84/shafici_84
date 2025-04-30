package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping
    public String greeting(){
        return "Hello Ca2213";
    }
    @GetMapping("/greet/{name}")
    public  String name(@PathVariable String name){
        return "Hello "+name;
    }
}
