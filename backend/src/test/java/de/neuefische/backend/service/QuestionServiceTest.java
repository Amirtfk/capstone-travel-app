package de.neuefische.backend.service;
import de.neuefische.backend.model.*;
import de.neuefische.backend.repo.QuestionRepo;
import de.neuefische.backend.repo.TravelUserRepo;
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
                        new QuestionsCatalog("sara", CountryPreference.USA, WeatherPreference.SNOWY,
                                        new UserPreference("sara", 0)),
                        new QuestionsCatalog("amir", CountryPreference.SPAIN, WeatherPreference.RAINY,
                                        new UserPreference("amir", 50)),
                        new QuestionsCatalog("david",CountryPreference.GERMANY, WeatherPreference.SUNNY,
                                        new UserPreference("david", 75))));
        // WHEN
        List<QuestionsCatalog> actual = service.getAllAnswers();

        // THEN
        List<QuestionsCatalog> expected = List.of(
                new QuestionsCatalog("sara", CountryPreference.USA, WeatherPreference.SNOWY,
                                new UserPreference("sara", 0)),
                new QuestionsCatalog("amir", CountryPreference.SPAIN, WeatherPreference.RAINY,
                                new UserPreference("amir", 50)),
                new QuestionsCatalog("david",CountryPreference.GERMANY, WeatherPreference.SUNNY,
                                new UserPreference("david", 75)));
        verify(repo).findAll();
        assertEquals(expected, actual);

    }

    @Test
    void postAnswers() {

        // GIVEN
        QuestionCatalogDto dummyQuestionDto = new QuestionCatalogDto(CountryPreference.USA, WeatherPreference.SNOWY);
        String username ="amir";
        when(repo.save(any())).thenReturn(QuestionsCatalog.builder()
                .username("amir")
                .countryPreference(dummyQuestionDto.getCountryPreference())
                .weatherPreference(dummyQuestionDto.getWeatherPreference())
                .userPreferences(new UserPreference("amir", 50))
                .build());
        // WHEN
        QuestionsCatalog actual = service.createQuestionCatalog(dummyQuestionDto, username);

        // THEN
        QuestionsCatalog expected = QuestionsCatalog.builder()
                .username("amir")
                .countryPreference(dummyQuestionDto.getCountryPreference())
                .weatherPreference(dummyQuestionDto.getWeatherPreference())
                .userPreferences(new UserPreference("amir", 50))
                .build();
        assertEquals(expected, actual);

    }

    @Test
    void calcMatch() {

        //GIVEN
        QuestionsCatalog dummyQuestions1 = new QuestionsCatalog("amir",CountryPreference.USA, WeatherPreference.SNOWY,
                        new UserPreference("amir", 0));
        QuestionsCatalog dummyQuestions2 = new QuestionsCatalog("joon",CountryPreference.GERMANY, WeatherPreference.RAINY,
                        new UserPreference("joon", 50));
        QuestionsCatalog dummyQuestions3 = new QuestionsCatalog("leon",CountryPreference.SPAIN, WeatherPreference.SUNNY,
                        new UserPreference("leon", 50));

        when(repo.findAll()).thenReturn(List.of(dummyQuestions1, dummyQuestions2, dummyQuestions3));

        QuestionsCatalog dummyQuestionUser = new QuestionsCatalog("marek", CountryPreference.GERMANY, WeatherPreference.SUNNY,
                        new UserPreference("name", 0));

        //WHEN
        List<UserPreference> actual = service.calcMatch(dummyQuestionUser);

        //THEN
        List<UserPreference> expected = List.of(new UserPreference("amir", 0),
                new UserPreference("joon", 50),
                new UserPreference("leon",50));
        assertEquals(expected, actual);

    }



}