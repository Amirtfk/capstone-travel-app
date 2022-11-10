package de.neuefische.backend.service;
import de.neuefische.backend.model.CountryPreference;
import de.neuefische.backend.model.QuestionsCatalog;
import de.neuefische.backend.model.UserPreference;
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
                        new QuestionsCatalog("sara", CountryPreference.USA, WeatherPreference.SNOWY, List.of(
                                        new UserPreference("sara", 0))),
                        new QuestionsCatalog("amir", CountryPreference.SPAIN, WeatherPreference.RAINY, List.of(
                                        new UserPreference("amir", 50))),
                        new QuestionsCatalog("david",CountryPreference.GERMANY, WeatherPreference.SUNNY, List.of(
                                        new UserPreference("david", 75)))));
        // WHEN
        List<QuestionsCatalog> actual = service.getAllAnswers();

        // THEN
        List<QuestionsCatalog> expected = List.of(
                new QuestionsCatalog("sara", CountryPreference.USA, WeatherPreference.SNOWY, List.of(
                                new UserPreference("sara", 0))),
                new QuestionsCatalog("amir", CountryPreference.SPAIN, WeatherPreference.RAINY, List.of(
                                new UserPreference("amir", 50))),
                new QuestionsCatalog("david",CountryPreference.GERMANY, WeatherPreference.SUNNY, List.of(
                                new UserPreference("david", 75))));
        verify(repo).findAll();
        assertEquals(expected, actual);

    }

    @Test
    void postAnswers() {

        // GIVEN
        QuestionsCatalog dummyQuestions = new QuestionsCatalog("amir",CountryPreference.USA, WeatherPreference.SNOWY, List.of(
                        new UserPreference("amir", 50)));
        when(repo.save(dummyQuestions)).thenReturn(dummyQuestions);

        // WHEN
        QuestionsCatalog actual = service.createQuestionCatalog(dummyQuestions);

        // THEN
        verify(repo).save(dummyQuestions);
        assertEquals(dummyQuestions, actual);

    }

    @Test
    void calcMatch() {

        //GIVEN
        QuestionsCatalog dummyQuestions1 = new QuestionsCatalog("amir",CountryPreference.USA, WeatherPreference.SNOWY, List.of(
                        new UserPreference("amir", 0)));
        QuestionsCatalog dummyQuestions2 = new QuestionsCatalog("joon",CountryPreference.GERMANY, WeatherPreference.RAINY, List.of(
                        new UserPreference("joon", 50)));
        QuestionsCatalog dummyQuestions3 = new QuestionsCatalog("leon",CountryPreference.SPAIN, WeatherPreference.SUNNY, List.of(
                        new UserPreference("leon", 50)));

        when(repo.findAll()).thenReturn(List.of(dummyQuestions1, dummyQuestions2, dummyQuestions3));

        QuestionsCatalog dummyQuestionUser = new QuestionsCatalog("marek", CountryPreference.GERMANY, WeatherPreference.SUNNY, List.of(
                        new UserPreference("name", 0)));

        //WHEN
        List<UserPreference> actual = service.calcMatch(dummyQuestionUser);

        //THEN
        List<UserPreference> expected = List.of(new UserPreference("amir", 0),
                new UserPreference("joon", 50),
                new UserPreference("leon",50));
        assertEquals(expected, actual);

    }



}