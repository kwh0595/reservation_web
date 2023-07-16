package com.projectDev.reservEat.controller;

import com.projectDev.reservEat.dto.MemberDTO;
import com.projectDev.reservEat.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberService memberService;
    @GetMapping("/")
    public String index(){
        return "reserveat"; //=> templates폴더의 reserveat.html을 찾아감
    }

    @GetMapping("/join_page")
    public String join_pageForm(){
        return "join_page";
    }

    @PostMapping("/join_page")
    public String join(MemberDTO memberDTO){
        System.out.println("MemberController.save");
        System.out.println("memberDTO = " + memberDTO);
        Long memberId = memberService.join(memberDTO);
        return "reserveat";
    }
}
