package com.bilal.catZone.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestingController {


    @GetMapping("/new")
    public String test(){
        return "new_profile";
    }


}
