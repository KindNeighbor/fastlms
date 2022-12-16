package com.example.fastlms.admin;

import com.example.fastlms.admin.dto.MemberDto;
import com.example.fastlms.admin.model.MemberParam;
import com.example.fastlms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminMemberController {

    private final MemberService memberService;

    @GetMapping("/admin/member/list.do")
    public String list(Model model, MemberParam parameter) {

        List<MemberDto> members = memberService.list(parameter);
        model.addAttribute("list", members);

        return "admin/member/list";
    }
}