package de.neuefische.backend.service;
import de.neuefische.backend.model.QuestionsCatalog;
import de.neuefische.backend.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionService {

    private final QuestionRepo repo;

    @Autowired
    public QuestionService(QuestionRepo repo) {
        this.repo = repo;
    }

    public List<QuestionsCatalog> getAllAnswers() {
        return repo.findAll(); //konnte ich anstatt findall() > getAllAnswers schreiben?
    }

    public QuestionsCatalog postAnswers(QuestionsCatalog questionsCatalog) {
        return repo.save(questionsCatalog);
    }

/*    public QuestionsCatalog postAnswers(QuestionsCatalog questionsCatalog) {
        questionsCatalog.setId(idService.generateId());

        return repo.save(movie);
    }*/
}
