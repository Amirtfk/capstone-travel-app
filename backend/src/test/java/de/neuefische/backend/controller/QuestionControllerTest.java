package de.neuefische.backend.controller;

import de.neuefische.backend.model.CountryPreference;
import de.neuefische.backend.model.QuestionsCatalog;
import de.neuefische.backend.model.UserPreference;
import de.neuefische.backend.model.WeatherPreference;
import de.neuefische.backend.repo.QuestionRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private QuestionRepo repo;


    @WithMockUser(username = "amir")
    @Test
    void createQuestionCatalog() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/travel")
                        .content("{\"countryPreference\":\"USA\",\"weatherPreference\":\"SUNNY\"}")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())

                .andExpect(content().json(
                        "{\"countryPreference\":\"USA\",\"weatherPreference\":\"SUNNY\"}"
                ));


        mockMvc.perform(MockMvcRequestBuilders.get("/api/travel"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"countryPreference\":\"USA\",\"weatherPreference\":\"SUNNY\"}]"));
    }


    @Test
    void calcMatch() throws Exception {
        QuestionsCatalog questionsCatalog1 = new QuestionsCatalog("amir", CountryPreference.USA, WeatherPreference.RAINY, UserPreference.builder().name("amir").perc(100).build());
        QuestionsCatalog questionsCatalog2 = new QuestionsCatalog("sara", CountryPreference.SPAIN, WeatherPreference.RAINY, UserPreference.builder().name("sara").perc(50).build());
        repo.save(questionsCatalog1);
        repo.save(questionsCatalog2);
        String request = """
                    {
                        "username": "leon",
                        "countryPreference": "USA",
                        "weatherPreference": "RAINY",
                        "userPreferences":
                              {
                              "name": "leon",
                              "perc": 50
                              }
                    }
                        """;
        String response = """
                    [
                          {
                          "name": "sara",
                          "perc": 50
                          },
                                                                              
                          {
                          "name": "amir",
                          "perc": 100
                          }
                    ]
                        """;
        mockMvc.perform(MockMvcRequestBuilders.post("/api/travel/match")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(request)
                ).andExpect(status().isOk())
                .andExpect(content().json(response));
    }
}