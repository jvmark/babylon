package com.onmysky.babylon.model.person.repository;

import com.onmysky.babylon.model.person.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mark on 15/11/11.
 */
@Repository
public class PersonRepository {

    @Autowired
    MongoTemplate testDB;

    public long countAllPersons() {
        return testDB.count(null, Person.class);
    }

    public Person findById(int id) {
        return testDB.findById(id, Person.class);
    }

    public List<Person> findAll() {
        return testDB.findAll(Person.class);
    }

    public int save(Person person) {
        testDB.save(person);
        return 1;
    }

}
