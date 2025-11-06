package com.springboot.springtest.entity;


import com.springboot.springtest.dto.ArticleForm;
import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;


    public Article(ArticleForm form) {
        this.id = form.getId();
        this.title = form.getTitle();
        this.content = form.getContent();
    }

}
