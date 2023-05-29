package com.innowise.dude_where_is_my_car.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.innowise.dude_where_is_my_car.dto.requests.user_requests.LoginDTO;
import com.innowise.dude_where_is_my_car.dto.responses.AuthResponseDTO;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//https://spring.io/guides/gs/testing-web/
//https://www.youtube.com/watch?v=Lnc3o8cCwZY
//https://www.baeldung.com/spring-security-integration-tests
//https://www.baeldung.com/oauth-api-testing-with-spring-mvc
@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@ContextConfiguration
@SqlGroup({@Sql(value = "classpath:test-user-data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        @Sql(value = "classpath:clear-test-user-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)})
public class AuthControllerTest {
    @Container
    public static PostgreSQLContainer<?> pgsql = new PostgreSQLContainer<>("postgres:15");
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;

    @DynamicPropertySource
    static void configurePgContainer(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", pgsql::getJdbcUrl);
        registry.add("spring.datasource.username", pgsql::getUsername);
        registry.add("spring.datasource.password", pgsql::getPassword);
    }

    private static String asJsonString(final Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    void accessDeniedIfWrongPasswordTest() throws Exception {
        String correctLogin = "admin";
        String wrongPassword = "Admin1112";

        mockMvc.perform(MockMvcRequestBuilders.post("/auth/v1/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new LoginDTO(correctLogin, wrongPassword))))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].error").value("Bad credentials"));

    }

    @Test
    void accessDeniedIfWrongLoginTest() throws Exception {
        String correctLogin = "adminn";
        String wrongPassword = "Admin1111";

        mockMvc.perform(MockMvcRequestBuilders.post("/auth/v1/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new LoginDTO(correctLogin, wrongPassword))))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].error").value("Bad credentials"));
    }

    @Test
    void loginUserTest() throws Exception {
        String correctLogin = "admin";
        String correctPassword = "Admin1111";

        MvcResult resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/auth/v1/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new LoginDTO(correctLogin, correctPassword)))
        ).andDo(print()).andExpect(status().isOk()).andReturn();
        String content = resultActions.getResponse().getContentAsString();
        AuthResponseDTO responseDTO = jsonStringToPojo(content, AuthResponseDTO.class);

        Assertions.assertNotNull(responseDTO.getAccessToken());

    }

    private <T> T jsonStringToPojo(String jsonInString, Class<T> obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonInString, obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
