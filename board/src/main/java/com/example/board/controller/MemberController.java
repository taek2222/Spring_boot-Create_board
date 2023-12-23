package com.example.board.controller;

import com.example.board.dto.MemberForm;
import com.example.board.entity.Members;
import com.example.board.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController
{
    @Autowired
    private MembersRepository membersRepository;
    @GetMapping("/join")
    public String newMembersForm() { return "members/new"; }

    @PostMapping("/join")
    public String createMembers(MemberForm form) {
        System.out.println(form.toString());

        Members members = form.toEntity();
        System.out.println(members.toString());

        Members saved = membersRepository.save(members);
        System.out.println(saved);
        return "redirect:/join";
    }
}
