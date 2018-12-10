/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lis.lisexercise.dao;

import com.lis.lisexercise.model.Person;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Chad
 */
public class PersonDbImpl implements PersonDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String SQL_INSERT_PERSON
            = "insert into person (personName, personAge, personTitle, personHTown) values (?, ?, ?, ?)";
    private static final String SQL_DELETE_PERSON
            = "delete from person where personId = ?";
    private static final String SQL_GET_ALL_USERS
            = "select * from person";
    private static final String SQL_GET_PERSON_BY_ID
            = "select * from person "
            + "where personId = ? ";

    // ===================================
    // PERSON STUFF
    // ===================================
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addPerson(Person person) {
        jdbcTemplate.update(SQL_INSERT_PERSON,
                person.getPersonName(),
                person.getPersonAge(),
                person.getPersonTitle(),
                person.getPersonHTown());

        person.setPersonId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
    }

    @Override
    public void removePerson(long personId) {
        jdbcTemplate.update(SQL_DELETE_PERSON, personId);
    }

    @Override
    public List<Person> getAllPersons() {
        return jdbcTemplate.query(SQL_GET_ALL_USERS, new PersonMapper());
    }

    @Override
    public Person getPersonById(long personId) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_PERSON_BY_ID, new PersonMapper(), personId);
        } catch (EmptyResultDataAccessException ex) {
            // return nothing if no person exists for now
            return null;
        }
    }

    // ===================================
    // MAPPERS
    // ===================================
    private static final class PersonMapper implements RowMapper<Person> {

        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person p = new Person();
            p.setPersonId(rs.getLong("personId"));
            p.setPersonName(rs.getString("personName"));
            p.setPersonAge(rs.getString("personAge"));
            p.setPersonTitle(rs.getString("personTitle"));
            p.setPersonHTown(rs.getString("personHTown"));
            return p;
        }
    }
}
