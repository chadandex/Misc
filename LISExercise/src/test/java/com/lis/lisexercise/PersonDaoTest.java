/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lis.lisexercise;

import com.lis.lisexercise.dao.PersonDao;
import com.lis.lisexercise.model.Person;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Chad
 */
public class PersonDaoTest {

    PersonDao dao;

    public PersonDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        dao = ctx.getBean("personDao", PersonDao.class);

        // delete all persons
        List<Person> p = dao.getAllPersons();
        for (Person currentP : p) {
            dao.removePerson(currentP.getPersonId());
        }

    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void addGetPerson() {
        Person p = new Person();
        p.setPersonName("Bob");
        p.setPersonAge("20");
        p.setPersonTitle("The tester");
        p.setPersonHTown("Super North of North");

        dao.addPerson(p);

        Person fromDao = dao.getPersonById(p.getPersonId());
        assertEquals(fromDao, p);
    }

    @Test
    public void deletePerson() {
        Person p = new Person();
        p.setPersonName("Bob2");
        p.setPersonAge("21");
        p.setPersonTitle("The tester of testers");
        p.setPersonHTown("Super North of South");

        dao.addPerson(p);

        Person fromDao = dao.getPersonById(p.getPersonId());
        assertEquals(fromDao, p);
        dao.removePerson(p.getPersonId());
        assertNull(dao.getPersonById(p.getPersonId()));
    }
}
