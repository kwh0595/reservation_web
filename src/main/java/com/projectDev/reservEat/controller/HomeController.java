package com.projectDev.reservEat.controller;

import com.mysql.cj.NativeQueryAttributesBindings;
import com.projectDev.reservEat.dto.MemberDTO;
import com.projectDev.reservEat.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final MemberService memberService;
    @GetMapping("/")
    public String index(){
        return "reserveat"; //=> templates폴더의 reserveat.html을 찾아감
    }

    @PostMapping("/")
    public String login(@ModelAttribute MemberDTO memberDTO,HttpSession session){
        System.out.println("login page");
        MemberDTO loginResult = memberService.login(memberDTO);
        if(loginResult !=null){
            //login 성공
            session.setAttribute("loginEmail",loginResult.getEmail());
            return "main";
        }
        else{
            //login 실패
            return "reserveat";
        }
    }

    @GetMapping("/join_page")
    public String join_pageForm(){
        return "join_page";
    }

    @PostMapping("/join_page")
    public String join(MemberDTO memberDTO){
        System.out.println("join page");
        System.out.println("memberDTO = " + memberDTO);
        Long memberId = memberService.join(memberDTO);
        return "reserveat";
    }
    @GetMapping("/INFO")
    public String information(MemberDTO memberDTO){
        return "my_info";
    }

    @GetMapping("/HOME")
    public String home(MemberDTO memberDTO){
        return "home";
    }

    @GetMapping("/SEARCH")
    public String search(MemberDTO memberDTO){
        return "search";
    }
}
