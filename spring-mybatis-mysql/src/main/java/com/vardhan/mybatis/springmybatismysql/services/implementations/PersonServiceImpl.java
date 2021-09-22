package com.vardhan.mybatis.springmybatismysql.services.implementations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vardhan.mybatis.springmybatismysql.mappers.PersonMapper;
import com.vardhan.mybatis.springmybatismysql.models.Person;
import com.vardhan.mybatis.springmybatismysql.services.PersonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {
	
	private static final Logger logger = Logger.getLogger(PersonServiceImpl.class);

	@Autowired private PersonMapper personMapper;
    
    @Override
    @Transactional
    public Person create(Person person) {
    	int id;
    	try {
    		logger.info("Creating a person");
			id = personMapper.insertPerson(person);
			person.setIdPerson(Long.valueOf(id));
		} catch (Exception e) {
			logger.error(e);
		}
		return person;
    }

    @Override
    public Person findById(String personId) {
    	logger.info("Finding a person by ID");
    	Person person = new Person();
		try {
    		logger.info("Finding all persons");
    		person = personMapper.findPersonById(Integer.valueOf(personId));
		} catch (Exception e) {
			logger.error(e);
		}
        return person;
    }

	@Override
    public List<Person> findAll() {
        ArrayList<Person> persons = new ArrayList<>();
    	try {
    		logger.info("Finding all persons");
            persons = (ArrayList<Person>) personMapper.findAllPersons();
		} catch (Exception e) {
			logger.error(e);
		}
        return persons;
    }
    
    @Override
    @Transactional
    public Person update(Person person) {
    	try {
    		logger.info("Updating a person");
			person = personMapper.updatePerson(person);
		} catch (Exception e) {
			logger.error(e);
		}
		return person;
    }

    @Override
    @Transactional
    public void delete(Person person) {
		try {
			logger.info("Deleting a person");
			personMapper.removePerson(person.getIdPerson().intValue());
		} catch (Exception ex) {
			logger.error(ex);
		}
    }

	@Override
	public List<Date> getCreatedDates() {
		List<Date> createdDates = null;
		try {
			logger.info("Getting created dates..");
			createdDates = personMapper.getPersons();
			createdDates.stream().forEach(date -> logger.info("Created Date: " + date));
		} catch (Exception ex) {
			logger.error(ex);
		}
		return createdDates;
	}

	@Override
	public List<Person> getPersonByDates(List<Date> createdDates) {
		List<Person> persons = null;
		try {
			logger.info("Getting person list by created dates..");
			persons = personMapper.getPersonByDates(createdDates);
			persons.stream().forEach(person -> logger.info("Person: " + person));
		} catch (Exception ex) {
			logger.error(ex);
		}
		return persons;
    }

}