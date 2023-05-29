package com.innowise.dude_where_is_my_car.repositories;

import com.innowise.dude_where_is_my_car.dto.requests.search_criteria.PageCriteria;
import com.innowise.dude_where_is_my_car.models.User;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

import java.util.List;

//https://blog.jdriven.com/2018/10/using-querydsl-annotation-processor-with-gradle-and-intellij-idea/
//https://www.baeldung.com/rest-api-search-language-spring-data-querydsl
public interface QUserSearchRepository {
    List<User> searchUser(Predicate searchRequestPredicate, OrderSpecifier<?> orderSpecifier, PageCriteria pageCriteria);
}



