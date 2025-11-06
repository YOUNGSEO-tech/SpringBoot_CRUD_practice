package com.springboot.springtest.service;

import com.springboot.springtest.dto.ArticleForm;
import com.springboot.springtest.entity.Article;
import com.springboot.springtest.repository.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.aspectj.weaver.ast.Literal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article create(ArticleForm form){
        Article article = form.toEntity();
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        return saved;
    }

    public List<Article> findAllArticles() {
        Iterable<Article> articles =  articleRepository.findAll();
        List<Article> articleList = new ArrayList<>();
        articles.forEach(articleList::add);
        return articleList;

    }

    public ArticleForm findById(Long id){
       Article article = articleRepository.findById(id).orElse(null);
       return new ArticleForm(
               article.getId(),
               article.getTitle(),
               article.getContent()
       );
    }

//    // 게시물 수정
//    public Article edit(Long id, ArticleForm form){
//        Article article = articleRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("게시물 없음 " + id));
//        article.setTitle(form.getTitle());
//        article.setContent(form.getContent());
//        articleRepository.save(article);
//        return article;
//    }

    public ArticleForm updateArticle(ArticleForm form) {
        Article article = new Article(form);
        article = articleRepository.save(article);
        return new ArticleForm(article);
    }

    public boolean delete(Long id) {
        Article target = articleRepository.findById(id).orElse(null);
        if (target != null) {
            articleRepository.delete(target);
            return true;
        }

        return false;
    }

}
