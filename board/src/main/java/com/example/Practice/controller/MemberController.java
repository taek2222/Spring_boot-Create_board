package com.example.Practice.controller;

import com.example.Practice.dto.MemberForm;
import com.example.Practice.entity.Members;
import com.example.Practice.repository.MembersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

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

        return "redirect:/members/" + saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        Members membersEntity = membersRepository.findById(id).orElse(null);
        model.addAttribute("members", membersEntity);
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        ArrayList<Members> membersEntity = membersRepository.findAll();
        model.addAttribute("membersList", membersEntity);
        return "members/index";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Members membersEntity = membersRepository.findById(id).orElse(null);
        model.addAttribute("members", membersEntity);
        return "members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form) {
        Members membersEntity = form.toEntity();
        Members target = membersRepository.findById(membersEntity.getId()).orElse(null);

        if (target != null)
            membersRepository.save(membersEntity);
        return "redirect:/members/" + membersEntity.getId();
    }

    @GetMapping("/members/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        Members tartget = membersRepository.findById(id).orElse(null);
        if(tartget != null) {
            membersRepository.delete(tartget);
            rttr.addFlashAttribute("msg", "삭제되었습니다!");
        }
        return "redirect:/members";
    }
}
