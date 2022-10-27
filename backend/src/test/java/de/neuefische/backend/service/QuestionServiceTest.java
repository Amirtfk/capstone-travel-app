package de.neuefische.backend.service;
import de.neuefische.backend.model.CountryPreference;
import de.neuefische.backend.model.QuestionsCatalog;
import de.neuefische.backend.model.WeatherPreference;
import de.neuefische.backend.repo.QuestionRepo;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class QuestionServiceTest {

    private final QuestionRepo repo = mock(QuestionRepo.class);
    private final QuestionService service = new QuestionService(repo);

    @Test
    void getAllAnswers() {

        // GIVEN
        when(repo.findAll())
                .thenReturn(List.of(
                        new QuestionsCatalog(CountryPreference.USA, WeatherPreference.SNOWY),
                        new QuestionsCatalog(CountryPreference.SPAIN, WeatherPreference.RAINY),
                        new QuestionsCatalog(CountryPreference.GERMANY, WeatherPreference.SUNNY)));
        // WHEN
        List<QuestionsCatalog> actual = service.getAllAnswers();

        // THEN
        List<QuestionsCatalog> expected = List.of(
                new QuestionsCatalog(CountryPreference.USA, WeatherPreference.SNOWY),
                new QuestionsCatalog(CountryPreference.SPAIN, WeatherPreference.RAINY),
                new QuestionsCatalog(CountryPreference.GERMANY, WeatherPreference.SUNNY));
        verify(repo).findAll();
        assertEquals(expected, actual);

    }

    @Test
    void postAnswers() {

        // GIVEN
        QuestionsCatalog dummyQuestions = new QuestionsCatalog(CountryPreference.USA, WeatherPreference.SNOWY);
        when(repo.save(dummyQuestions)).thenReturn(dummyQuestions);

        // WHEN
        QuestionsCatalog actual = service.postAnswers(dummyQuestions);

        // THEN
        verify(repo).save(dummyQuestions);
        assertEquals(dummyQuestions, actual);

    }


}