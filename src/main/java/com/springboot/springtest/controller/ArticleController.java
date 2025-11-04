package com.springboot.springtest.controller;


import com.springboot.springtest.dto.ArticleForm;
import com.springboot.springtest.entity.Article;
import com.springboot.springtest.repository.ArticleRepository;
import com.springboot.springtest.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Literal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public String index (Model model){
        List<Article>  articleEntityList = articleService.findAllArticles();
        model.addAttribute("articleList",articleEntityList);
        return "articles/index";
    }

    @GetMapping("/articles/new")
    public String newArticle(){
        return "articles/new";
    }



    // 게시물 생성
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        System.out.println(form.toString());
        log.info(form.toString());
        Article article = form.toEntity();
        log.info(article.toString());


        Article saved = articleService.create(form);
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    // 게시물 전체 조회
    @GetMapping("/articles/list")
    public String articleList(Model model){
        List<Article> articleList = articleService.findAllArticles();
        model.addAttribute("articles", articleList);
        return "articles/articlelist";
    }

    // 게시물 단일 조회
    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id = " + id);
        ArticleForm articleEntity = articleService.findById(id);
        System.out.println(articleEntity.toString());
        model.addAttribute("article", articleEntity);
        return "articles/show";
    }

    //게시물 수정
    @PatchMapping("/articles/{id}")
    @ResponseBody
    public Article update(@PathVariable Long id, @RequestBody ArticleForm form) {
        Article article = articleService.edit(id, form);
        return article;
    }

    @GetMapping("/articles/{id}/edit")
    public String update(@PathVariable Long id , Model model) {
        model.addAttribute("article", articleService.findById(id));
        return "articles/edit";
    }

    // 게시물 삭제
    @DeleteMapping
    public String delete(@PathVariable Long id, Model model) {
         return null;
    }

}
