package com.vardhan.mybatis.springmybatismysql.mappers;

import com.vardhan.mybatis.springmybatismysql.models.Person;

import java.util.Date;
import java.util.List;

public interface PersonMapper {
    int insertPerson(Person person);
    Person findPersonById(Integer id);
    List<Person> findAllPersons();
    Person updatePerson(Person person);
    void removePerson(Integer idPerson);
    List<Date> getPersons(); //test1
    List<Person> getPersonByDates(List<Date> createdDates);
}
