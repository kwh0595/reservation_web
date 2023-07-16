package com.projectDev.reservEat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "reserveat"; //=> templates폴더의 reserveat.html을 찾아감
    }
}
