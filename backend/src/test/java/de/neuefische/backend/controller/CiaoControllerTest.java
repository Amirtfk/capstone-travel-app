package de.neuefische.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CiaoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void ShouldReturn_Unauthorized_When_Request_Without_Login() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/ciao"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "user1", password = "123")
    void ShouldReturn_Ciao_When_Request_With_Login() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/ciao"))
                .andExpect(status().isOk())
                .andExpect(content().string("Ciao World!"));
    }

}
