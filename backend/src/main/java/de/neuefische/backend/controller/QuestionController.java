package de.neuefische.backend.controller;

import de.neuefische.backend.model.QuestionsCatalog;
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
    public QuestionsCatalog postAnswer(@RequestBody QuestionsCatalog questionsCatalog) {
        String username = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        questionsCatalog.setUsername(username);
        return service.postAnswers(questionsCatalog);

    }
}
