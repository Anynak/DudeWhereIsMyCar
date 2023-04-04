package com.innowise.DudeWhereIsMyCar.repositories;

import com.innowise.DudeWhereIsMyCar.models.User;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
//https://blog.jdriven.com/2018/10/using-querydsl-annotation-processor-with-gradle-and-intellij-idea/
//https://www.baeldung.com/rest-api-search-language-spring-data-querydsl
public interface UserSearchQRepo extends JpaRepository<User, Long> {
    //default List<User> findByName(String name) {
    //    JPAQuery<User> query = new JPAQuery<>(this.getEntityManager());
    //    StringPath namePath = user.name; // Use the generated QUser class to reference the entity and its properties
    //    StringExpression nameLower = namePath.lower();
    //    return query.from(user)
    //            .where(nameLower.contains(name.toLowerCase()))
    //            .fetch();
    //}
}
