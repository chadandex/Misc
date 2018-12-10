/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lis.lisexercise.service;

import com.lis.lisexercise.dao.PersonDao;
import com.lis.lisexercise.model.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Chad
 */
@Service
public class PersonServiceImpl implements PersonService {
    
    @Autowired(required = true)
    PersonDao dao;
    
     public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public void addPerson(Person person) {
        dao.addPerson(person);
    }

    @Override
    public void removePerson(long personId) {
        dao.removePerson(personId);
    }

    @Override
    public List<Person> getAllPersons() {
        return dao.getAllPersons();
    }
    
    @Override
    public Person getPersonById(long personId) {
        return dao.getPersonById(personId);
    }
}
