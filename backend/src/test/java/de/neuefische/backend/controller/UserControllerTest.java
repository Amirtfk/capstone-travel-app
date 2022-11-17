package de.neuefische.backend.controller;

import de.neuefische.backend.model.*;
import de.neuefische.backend.repo.TravelUserRepo;
import de.neuefische.backend.service.AppUsersDetailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Collections;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private TravelUserRepo repo;

    @MockBean
    private AppUsersDetailService service;



    @Test
    @WithMockUser(username = "user1", password = "123")
    void ShouldReturn_user_When_Request_With_Login() throws Exception {
        QuestionsCatalog dummyQCatalog = new QuestionsCatalog("user1", CountryPreference.GERMANY, WeatherPreference.SUNNY, new UserPreference());
        TravelUser dummyTravelUser = new TravelUser("user1", "ajdhasdjasjg", "hasd@hd.com", dummyQCatalog);

        when(repo.findById(any())).thenReturn(Optional.of(dummyTravelUser));

        when(service.loadUserByUsername(any())).thenReturn(new User(dummyTravelUser.getUsername(), dummyTravelUser.getPasswordHash(), Collections.emptyList()));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/login"))
                .andExpect(status().isOk())
                .andExpect(content().string("user1"));
    }


    @Test
    void ShouldReturn_null_with_Logout () throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/logout"))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }



}
