package com.example.board.service;

import com.example.board.dto.CommentDto;
import com.example.board.entity.Article;
import com.example.board.entity.Comment;
import com.example.board.repository.ArticleRepository;
import com.example.board.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleRepository articleRepository;


    public List<CommentDto> comments(Long articleId) {
//        List<Comment> comments = commentRepository.findByArticleId(articleId);
//        List<CommentDto> dtos = new ArrayList<CommentDto>();
//        for (Comment c : comments) {
//            CommentDto dto = CommentDto.createCommentDto(c);
//            dtos.add(dto);
//        }
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(CommentDto::createCommentDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CommentDto create(Long articleId, CommentDto dto) throws IllegalAccessException {
        Article article = articleRepository.findById(articleId).orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패! " + "대상 게시글이 없습니다."));
        Comment comment = Comment.createComment(dto, article);
        Comment created = commentRepository.save(comment);
        return  CommentDto.createCommentDto(created);
    }
}
