package de.neuefische.backend.controller;

import de.neuefische.backend.model.QuestionCatalogDto;
import de.neuefische.backend.model.QuestionsCatalog;
import de.neuefische.backend.model.UserPreference;
import de.neuefische.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/travel")
public class QuestionController {

    private final QuestionService service;

    @Autowired
    public QuestionController(QuestionService service) {
        this.service = service;
    }


    @GetMapping
    public List<QuestionsCatalog> getAllAnswers() {
        return service.getAllAnswers();
    }

    @PostMapping
    public QuestionsCatalog createQuestionCatalog(@RequestBody QuestionCatalogDto questionCatalogDto) {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        QuestionsCatalog questionsCatalog = new QuestionsCatalog();
        questionsCatalog.setCountryPreference(questionCatalogDto.getCountryPreference());
        questionsCatalog.setWeatherPreference(questionCatalogDto.getWeatherPreference());
        questionsCatalog.setUsername(username);

        return service.createQuestionCatalog(questionsCatalog);
    }


    @PostMapping("/match")
    public List<UserPreference> calcMatch (@RequestBody QuestionsCatalog questionsCatalog) {
        return service.calcMatch(questionsCatalog);
    }



}
