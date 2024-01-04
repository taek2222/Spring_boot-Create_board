package com.example.board.controller;

import com.example.board.dto.MemberForm;
import com.example.board.entity.Members;
import com.example.board.repository.MembersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController
{
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MembersRepository membersRepository;
    @GetMapping("/singup")
    public String newMembersForm() { return "members/new"; }

    @PostMapping("/join")
    public String createMembers(MemberForm form) {
        log.info(form.toString());

        Members members = form.toEntity();
        log.info(members.toString());

        Members saved = membersRepository.save(members);
        log.info(saved.toString());

        return "redirect:/singup";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        Members membersEntity = membersRepository.findById(id).orElse(null);
        model.addAttribute("members", membersEntity);
        return "members/show";
    }
}
