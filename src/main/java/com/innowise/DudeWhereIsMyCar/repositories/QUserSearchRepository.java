package com.innowise.DudeWhereIsMyCar.repositories;

import com.innowise.DudeWhereIsMyCar.dto.requests.searchCriteria.PageCriteria;
import com.innowise.DudeWhereIsMyCar.models.User;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

import java.util.List;

//https://blog.jdriven.com/2018/10/using-querydsl-annotation-processor-with-gradle-and-intellij-idea/
//https://www.baeldung.com/rest-api-search-language-spring-data-querydsl
public interface QUserSearchRepository {
    List<User> searchUser(Predicate searchRequestPredicate, OrderSpecifier<?> orderSpecifier, PageCriteria pageCriteria);
}



