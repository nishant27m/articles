package com.nc.restapi.articles.service;


import com.nc.restapi.articles.domain.Article;
import com.nc.restapi.articles.domain.TagInformation;
import com.nc.restapi.articles.domain.Tags;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    //@Test
    public void testSaveArticle() {
        Article article = new Article();
        article.setTitle("latest science shows that potato chips are better for you than sugar");
        article.setBody("some text, potentially containing simple markup about how potato chips are great");
        Date date = Calendar.getInstance().getTime();
        article.setDate(date);
        Set<Tags> tagsList = new LinkedHashSet<>();
        Tags tag = new Tags();
        tag.setName("health");
        tagsList.add(tag);
        tag = new Tags();
        tag.setName("fitness");
        tagsList.add(tag);
        tag = new Tags();
        tag.setName("science");
        tagsList.add(tag);
        article.setTags(tagsList);
        Article savedArticle = articleService.saveArticle(article);
        Assert.assertNotNull(savedArticle);
    }

    @Test
    public void testGetArticle() {
        Assert.assertNotNull(articleService.getArticle(new Long(6)));
    }

    @Test
    public void testGetArticles() {
        Assert.assertNotNull(articleService.getArticles());
    }

    @Test
    public void testGetTagInformation() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(2018, 07, 15, 0, 0, 0);
        Date date = cal.getTime(); // get back a Date object
        TagInformation tagInformation = articleService.getTagInformation("health", date);
        Assert.assertNotNull(tagInformation);
    }
}
