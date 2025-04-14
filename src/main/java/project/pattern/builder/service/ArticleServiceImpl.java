package project.pattern.builder.service;

import project.pattern.builder.domain.Article;
import project.pattern.builder.domain.ArticleForm;

import java.util.List;

public interface ArticleServiceImpl {
    List<Article> findAll();
    void save(ArticleForm form);
}
