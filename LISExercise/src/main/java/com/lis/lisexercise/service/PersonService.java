/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lis.lisexercise.service;

import com.lis.lisexercise.model.Person;
import java.util.List;

/**
 *
 * @author Chad
 */
public interface PersonService {
    // add the given Person to the data store
    public void addPerson(Person person);

    // remove the Person with the given id from the data store
    public void removePerson(long personId);
    
    // retrieve all Persons from the data store
    public List<Person> getAllPersons();
    
    // retrieve one person info by their id
    public Person getPersonById(long personId);
}
