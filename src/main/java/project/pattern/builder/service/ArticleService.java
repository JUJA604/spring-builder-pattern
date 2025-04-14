package project.pattern.builder.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.pattern.builder.domain.Article;
import project.pattern.builder.domain.ArticleForm;
import project.pattern.builder.repository.ArticleRepository;

import java.util.List;

@Service
public class ArticleService implements ArticleServiceImpl {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }
    @Override
    public void save(ArticleForm form) {
        Article article = Article.builder()
                .title(form.getTitle())
                .content(form.getContent())
                .build();

        articleRepository.save(article);
    }
}
