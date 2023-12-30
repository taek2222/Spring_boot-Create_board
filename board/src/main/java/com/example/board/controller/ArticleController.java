package com.example.board.controller;

import com.example.board.dto.ArticleForm;
import com.example.board.entity.Article;
import com.example.board.repository.ArticleRepository;
import io.micrometer.common.util.internal.logging.InternalLogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {
    private static final Logger log = LoggerFactory.getLogger(Log.class);

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public  String newArticleForm() {
        return "articles/new";
    }

    @Slf4j
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        InternalLogger log;
        log.info(form.toString());
        System.out.println(form.toString());
        // 1. DTO를 엔터리로 변환
        Article article = form.toEntity();
        System.out.println(article.toString());
        // 2. 리파지터리로 엔터티를 DB에 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved);
        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id) {
        log.info("id = " + id);
        return "";
    }
}
