package com.innowise.dude_where_is_my_car.repository;

import com.innowise.dude_where_is_my_car.models.Role;
import com.innowise.dude_where_is_my_car.models.User;
import com.innowise.dude_where_is_my_car.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@DataJpaTest
@SqlGroup({@Sql(value = "classpath:test-user-data.sql", executionPhase = BEFORE_TEST_METHOD)})
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void saveUserTest() {
        User user = generateUsers(1).get(0);

        User savedUser = userRepository.save(user);

        assertNotNull(savedUser);
        assertTrue(savedUser.getUserId() > 0);

    }

    @Test
    public void findUserBuLoginTest() {
        String testLogin = "testLogin";

        Optional<User> optUser = userRepository.findUserByLogin(testLogin);

        assertTrue(optUser.isPresent());
        User user = optUser.get();
        assertEquals(testLogin, user.getLogin());
    }

    @Test
    public void findByIdTest() {
        Long testId = 10000L;

        Optional<User> optUser = userRepository.findById(testId);

        assertTrue(optUser.isPresent());
        User user = optUser.get();
        assertEquals(testId, user.getUserId());
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
