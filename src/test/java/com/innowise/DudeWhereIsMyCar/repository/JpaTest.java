package com.innowise.DudeWhereIsMyCar.repository;

import com.innowise.DudeWhereIsMyCar.controllers.AuthController;
import com.innowise.DudeWhereIsMyCar.model.Role;
import com.innowise.DudeWhereIsMyCar.model.User;
import com.innowise.DudeWhereIsMyCar.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.springframework.test.web.servlet.MockMvc;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
//https://spring.io/guides/gs/testing-web/
//https://www.youtube.com/watch?v=Lnc3o8cCwZY
@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
public class JpaTest {
    @Autowired
    private MockMvc mockMvc;
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
    @Test
    public void contextLoads() throws Exception {
        assertThat(authController).isNotNull();
    }
    @Test
    public void saveUserTest() {
        User user = generateUsers(1).get(0);

        User savedUser = userRepository.save(user);

        List<User> users = userRepository.findAll();
        System.out.println(users.size());
        assertNotNull(savedUser);
        assertTrue(savedUser.getUserId() > 0);

    }
    private List<User> generateUsers(int n) {
        List<User> users = new ArrayList<>();

        Role role = new Role();
        role.setRoleId(2);
        role.setRoleName("USER");
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);

        for (int i = 0; i < n; i++) {
            User user = new User();
            user.setRoles(roleList);
            user.setName("" + System.nanoTime());
            user.setLogin("" + System.nanoTime());
            user.setEmail("" + System.nanoTime());
            user.setPhone("" + System.nanoTime());
            user.setCity("" + System.nanoTime());
            user.setCountry("" + System.nanoTime());
            user.setPasswordHash("" + System.nanoTime());
            users.add(user);

        }
        return users;
    }
}
