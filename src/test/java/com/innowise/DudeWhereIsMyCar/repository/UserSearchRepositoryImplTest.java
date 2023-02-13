package com.innowise.DudeWhereIsMyCar.repository;

import com.innowise.DudeWhereIsMyCar.Const.Const;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.SearchUserRequest;
import com.innowise.DudeWhereIsMyCar.DTO.requestsDTO.searchCriteria.SortingCriteria;
import com.innowise.DudeWhereIsMyCar.model.User;
import com.innowise.DudeWhereIsMyCar.repositories.UserSearchRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@DataJpaTest
@Import(UserSearchRepositoryImpl.class)
@SqlGroup({@Sql(value = "classpath:test-user-data.sql", executionPhase = BEFORE_TEST_METHOD)})
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserSearchRepositoryImplTest {

    @Autowired
    private UserSearchRepositoryImpl userSearchRepository;

    @Test
    public void checkMinPageSizeWithDefaultSearchParameters() {
        int pageSize = Const.MIN_PAGE_SIZE;
        SearchUserRequest searchUserRequest = new SearchUserRequest();
        PageCriteria pageCriteria = new PageCriteria();
        SortingCriteria sortingCriteria = new SortingCriteria();

        List<User> users = userSearchRepository.search(searchUserRequest, pageCriteria, sortingCriteria);

        Assertions.assertEquals(pageSize, users.size());
    }

    @Test
    public void checkCorrectPageSize() {
        int pageSize = 7;
        PageCriteria pageCriteria = new PageCriteria();
        pageCriteria.setPageSize(pageSize);
        SearchUserRequest searchUserRequest = new SearchUserRequest();
        SortingCriteria sortingCriteria = new SortingCriteria();

        List<User> users = userSearchRepository.search(searchUserRequest, pageCriteria, sortingCriteria);

        Assertions.assertEquals(pageSize, users.size());
    }

    @Test
    public void checkCorrectPageNumber() {
        SearchUserRequest searchUserRequest = new SearchUserRequest();
        SortingCriteria sortingCriteria = new SortingCriteria();
        PageCriteria pageCriteria = new PageCriteria();

        int pageSize = 5;
        int firstPageNumber = 1;
        pageCriteria.setPageSize(pageSize);
        pageCriteria.setPageNumber(firstPageNumber);
        List<User> usersInFirstPage = userSearchRepository.search(searchUserRequest, pageCriteria, sortingCriteria);

        int secondPageNumber = 2;
        pageCriteria.setPageNumber(secondPageNumber);
        List<User> usersInSecondPage = userSearchRepository.search(searchUserRequest, pageCriteria, sortingCriteria);

        int generalPageSize = pageSize * 2;
        pageCriteria.setPageSize(generalPageSize);
        pageCriteria.setPageNumber(firstPageNumber);
        List<User> usersInGeneralPage = userSearchRepository.search(searchUserRequest, pageCriteria, sortingCriteria)
                .stream().sorted(Comparator.comparing(User::getUserId)).collect(Collectors.toList());

        System.out.println(usersInGeneralPage);
        List<User> sumOfPages = new ArrayList<>(usersInFirstPage);
        sumOfPages.addAll(usersInSecondPage);
        System.out.println(sumOfPages);
        List<User> sortedSumOfPages = sumOfPages.stream().sorted(Comparator.comparing(User::getUserId)).collect(Collectors.toList());

        Assertions.assertEquals(usersInGeneralPage, sortedSumOfPages);
    }

}
