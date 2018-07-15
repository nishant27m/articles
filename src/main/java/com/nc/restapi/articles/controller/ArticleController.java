package com.nc.restapi.articles.controller;

import com.nc.restapi.articles.domain.Article;
import com.nc.restapi.articles.domain.TagInformation;
import com.nc.restapi.articles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/articles")
    public Article createArticle(@Valid @RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    @GetMapping("/articles/{id}")
    public Article getArticle(@PathVariable(value = "id") Long id) {
        return articleService.getArticle(id);
    }

    @GetMapping("/tag/{tagName}/{date}")
    public TagInformation getTagInformation(@PathVariable(value = "tagName") String tagName, @PathVariable(value = "date") Date date) {
        return articleService.getTagInformation(tagName, date);
    }
}
