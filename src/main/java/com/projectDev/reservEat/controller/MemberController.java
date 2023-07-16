package com.projectDev.reservEat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
    @GetMapping("/join_page")
    public String join_pageForm(){
        return "join_page";
    }

    @PostMapping("/join_page")
    public String join(@RequestParam("memberEmail")String memberEmail,
                       @RequestParam("memberPassword")String memberPassword,
                       @RequestParam("memberName")String memberName){
        System.out.println("MemberController.save");
        System.out.println("memberEmail = "+memberEmail +", memberPassword = "+memberPassword+", memberName = "+memberName);
        return "reserveat";
    }
}
