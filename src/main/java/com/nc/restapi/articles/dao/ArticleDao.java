package com.nc.restapi.articles.dao;


import com.nc.restapi.articles.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArticleDao extends JpaRepository<Article, Long> {

    List<Article> findByTagsNameIn(String name);

    List<Article> findByDateAndTagsNameIn(Date date, String name);

    List<Article> findByDate(Date date);

}
