package com.vardhan.mybatis.springmybatismysql.services;

import com.vardhan.mybatis.springmybatismysql.models.Person;

import java.util.Date;
import java.util.List;

public interface PersonService {
    
    Person create(final Person person);
    Person findById(final String personId);
    List<Person> findAll();
    Person update(Person person);
    void delete(Person person);
    List<Date> getCreatedDates();
    List<Person> getPersonByDates(List<Date> createdDates);
}