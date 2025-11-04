package com.springboot.springtest.repository;


import com.springboot.springtest.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository  extends CrudRepository<Article,Long> {

}
