package project.pattern.builder.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.pattern.builder.domain.Article;
import project.pattern.builder.domain.ArticleForm;
import project.pattern.builder.service.ArticleService;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public String articlePage(Model model) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "articleList";
    }

    @GetMapping("/write")
    public String articleWrite() {
        return "articleWrite";
    }

    @PostMapping
    public String article(@ModelAttribute ArticleForm form) {
        articleService.save(form);
        return "redirect:/article";
    }
}
