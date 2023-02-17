package com.innowise.DudeWhereIsMyCar.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.LoginDTO;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.DTO.responceDTO.AuthResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testcontainers.shaded.org.hamcrest.Matchers.hasSize;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@ContextConfiguration
@SqlGroup({@Sql(value = "classpath:test-user-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        @Sql(value = "classpath:clear-test-user-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)})
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Container
    public static PostgreSQLContainer<?> pgsql = new PostgreSQLContainer<>("postgres:15");

    @DynamicPropertySource
    static void configurePgContainer(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", pgsql::getJdbcUrl);
        registry.add("spring.datasource.username", pgsql::getUsername);
        registry.add("spring.datasource.password", pgsql::getPassword);
    }

    @Test
    public void givenInvalidRole_whenGetSecureRequest_thenForbidden() throws Exception {
        String accessToken = obtainAccessToken("admin", "Admin1111");

        mockMvc.perform(MockMvcRequestBuilders.get("/users/v1")
                        .header("Authorization", "Bearer " + accessToken)
                        .content(asJsonString(new PageCriteria())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(10)).isArray())
        ;
    }

    private String obtainAccessToken(String login, String password) throws Exception {
        MvcResult resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/auth/v1/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new LoginDTO(login, password)))
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        String content = resultActions.getResponse().getContentAsString();
        AuthResponseDTO responseDTO = jsonStringToPojo(content, AuthResponseDTO.class);
        return responseDTO.getAccessToken();
    }

    private <T> T jsonStringToPojo(String jsonInString, Class<T> obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonInString, obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String asJsonString(final Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
