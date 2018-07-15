package com.nc.restapi.articles.service;


import com.nc.restapi.articles.dao.ArticleDao;
import com.nc.restapi.articles.domain.Article;
import com.nc.restapi.articles.domain.TagInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;


    public List<Article> getArticles() {
        return articleDao.findAll();
    }

    public Article getArticle(Long id) {
        if (articleDao.findById(id).isPresent()) {
            return articleDao.findById(id).get();
        }
        else {
            throw new IllegalArgumentException(" Article with id "+id+" not found.");
        }
    }

    public Article saveArticle(Article article) {
        return articleDao.save(article);
    }

    public TagInformation getTagInformation(String tagName, Date date) {
        TagInformation tagInformation = new TagInformation();
        List<Article> articles = articleDao.findByDate(date);
        tagInformation.setCount(articles.size());
        final Set<Long> articleIds = new LinkedHashSet<>();
        final Set<String> relatedTagNames = new LinkedHashSet <>();
        articles.stream().forEach(article -> {
            articleIds.add(article.getId());
            article.getTags().stream().filter(tag -> !tag.getName().equals(tagName))
                    .forEach(tag -> relatedTagNames.add(tag.getName()));
        });
        tagInformation.setArticlesId(articleIds);
        tagInformation.setTags(relatedTagNames);
        return tagInformation;
    }
}
