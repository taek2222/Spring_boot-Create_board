package com.example.board.controller;

import com.example.board.dto.ArticleForm;
import com.example.board.entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public  String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString());
        // 1. DTO를 엔터리로 변환
        Article article = form.toEntity();
        // 2. 리파지터리로 엔터티를 DB에 저장
        Article saved = articleRepository.save(article);
        return "";
    }
}
