package com.innowise.DudeWhereIsMyCar.controller;


import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.LoginDTO;
import com.innowise.DudeWhereIsMyCar.controllers.AuthController;
import com.innowise.DudeWhereIsMyCar.model.Role;
import com.innowise.DudeWhereIsMyCar.model.User;
import com.innowise.DudeWhereIsMyCar.repositories.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;


import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
//https://spring.io/guides/gs/testing-web/
//https://www.youtube.com/watch?v=Lnc3o8cCwZY
//https://www.baeldung.com/spring-security-integration-tests
@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
@ContextConfiguration
//@SqlGroup({@Sql(value = "classpath:test-user-data.sql", executionPhase = BEFORE_TEST_METHOD)})
public class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    //@Container
    //public static PostgreSQLContainer<?> pgsql = new PostgreSQLContainer<>("postgres:12");
//
    //@DynamicPropertySource
    //static void configurePgContainer(DynamicPropertyRegistry registry){
    //    registry.add("spring.datasource.url", pgsql::getJdbcUrl);
    //    registry.add("spring.datasource.username", pgsql::getUsername);
    //    registry.add("spring.datasource.password", pgsql::getPassword);
    //}
    @Autowired
    private AuthController authController;
    @Autowired
    private UserRepository userRepository;
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }
    @Test
    public void accessDeniedTest() throws Exception {
        this.mockMvc.perform(get("/api")).andDo(print()).andExpect(status().isUnauthorized());
        assertThat(authController).isNotNull();
    }
    @Test
    public void loginUserTest() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.post("/auth/v1/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new LoginDTO("admin","Admin1111")))

        ).andDo(print()).andExpect(status().isOk());

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
