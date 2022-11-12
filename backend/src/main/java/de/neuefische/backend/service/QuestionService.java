package de.neuefische.backend.service;
import de.neuefische.backend.model.QuestionsCatalog;
import de.neuefische.backend.model.UserPreference;
import de.neuefische.backend.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class QuestionService {

    private final QuestionRepo repo;

    @Autowired
    public QuestionService(QuestionRepo repo) {
        this.repo = repo;
    }


    public List<QuestionsCatalog> getAllAnswers() {
        return repo.findAll();
    }

    public QuestionsCatalog createQuestionCatalog (QuestionsCatalog questionsCatalog) {

        if (repo.existsById(questionsCatalog.getUsername())) {
          QuestionsCatalog questionsCatalog1 =  repo.findById(questionsCatalog.getUsername())
                  .orElseThrow(() -> new NoSuchElementException("No Element with Question ID"));
          questionsCatalog1.setCountryPreference(questionsCatalog.getCountryPreference());
          questionsCatalog1.setWeatherPreference(questionsCatalog.getWeatherPreference());
            return repo.save(questionsCatalog1);
        }
        return repo.save(questionsCatalog);
    }


    public List<UserPreference> calcMatch(QuestionsCatalog requestUser) {

        List<QuestionsCatalog> users = getAllAnswers();
        List<UserPreference> userPreferences = new ArrayList<>();

        for (QuestionsCatalog user: users) {
            double count = 0;
            if (!user.getUsername().equals(requestUser.getUsername())) {

                if (user.getCountryPreference().equals(requestUser.getCountryPreference())) {
                    count++;
                }
                if (user.getWeatherPreference().equals(requestUser.getWeatherPreference())) {
                    count++;
                }


                double percent = count / 2 * 100;
                userPreferences.add(UserPreference.builder().name(user.getUsername())
                        .perc(percent).build());
            }
        }
        return userPreferences;

    }



}
