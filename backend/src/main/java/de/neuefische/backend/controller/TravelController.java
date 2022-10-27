package de.neuefische.backend.controller;
import de.neuefische.backend.model.QuestionsCatalog;
import de.neuefische.backend.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/travel")
public class TravelController {

    private final TravelService service;

    @Autowired
    public TravelController(TravelService service) {
        this.service = service;
    }


    @GetMapping
    public List<QuestionsCatalog> getAllAnswers() {
        return service.getAllAnswers();
    }

    @PostMapping
    public QuestionsCatalog postAnswer(@RequestBody QuestionsCatalog questionsCatalog) {
        return service.postAnswers(questionsCatalog);
    }
}
