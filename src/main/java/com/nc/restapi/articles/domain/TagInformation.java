package com.nc.restapi.articles.domain;


import java.util.List;
import java.util.Set;

public class TagInformation {

    private String name;

    private int count;

    private Set<Long> articlesId;

    private Set<String> tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set <Long> getArticlesId() {
        return articlesId;
    }

    public void setArticlesId(Set <Long> articlesId) {
        this.articlesId = articlesId;
    }

    public Set <String> getTags() {
        return tags;
    }

    public void setTags(Set <String> tags) {
        this.tags = tags;
    }

}
