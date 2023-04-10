package com.example.MMS.controller;

import com.example.MMS.domain.Member;
import com.example.MMS.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;
    /*
    의존성 주입 @Autowired가 있으면 스프링이 연관된 객체를 스프링 컨테이너에 찾아서 넣어줌.
    DI(Dependency Injection) : 의존성 주입
     Controller는 스프링이 제공하는 컨트롤러여서 스프링 빈으로 자동 등록 됨
     */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "members/memberList";
    }



}
