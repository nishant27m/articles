package com.nc.restapi.articles.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * This class represents Article entity and used for persistence and retrieval of data from database.
 */

@Entity(name = "articles")
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Column(name = "body")
    private String body;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Tags> tags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set <Tags> getTags() {
        return tags;
    }

    public void setTags(Set <Tags> tags) {
        this.tags = tags;
    }
}
