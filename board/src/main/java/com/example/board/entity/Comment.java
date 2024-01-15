package com.example.board.entity;

import com.example.board.dto.CommentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Column
    private String nickname;

    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Article article) throws IllegalAccessException {
        if (dto.getId() != null)
            throw new IllegalAccessException("댓글 생성 실패! 댓글의 id가 없어야 합니다.");
        if (!Objects.equals(dto.getArticleId(), article.getId()))
            throw new IllegalAccessException("댓글 생성 실패! 게시글의 id가 잘못됐습니다.");

        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }
}
