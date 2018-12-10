/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lis.lisexercise.controller;

import com.lis.lisexercise.model.Person;
import com.lis.lisexercise.service.PersonServiceImpl;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Chad
 */
@Controller
public class PersonController {

    @Autowired
    PersonServiceImpl service;

    @Inject
    public PersonController(PersonServiceImpl service) {
        this.service = service;
    }

    // ===================================
    // HOME PAGE
    // ===================================
    @RequestMapping(value = {"/", "/displayHomePage"}, method = RequestMethod.GET)
    public String displayHomePage(Model model) {

        // Display homepage
        return "homepage";
    }

    // ===================================
    // CONFIRMATION PAGE
    // ===================================
    @RequestMapping(value = "/displayConfirmationPage", method = RequestMethod.GET)
    public String displayConfirmationPage(HttpServletRequest request, Model model) {
        // Get submitted person Id to display recent data
        String personIdParameter = request.getParameter("confirmedPerson");
        int personId = Integer.parseInt(personIdParameter);

        // Get only submitted person's Id with it's info
        Person currentP = service.getPersonById(personId);

        // Get all the Persons
        List<Person> personList = service.getAllPersons();

        // Put the List of Persons on the Model
        model.addAttribute("personList", personList);
        model.addAttribute("currentP", currentP);

        // Return View component
        return "confirmationPage";
    }

    @RequestMapping(value = "/createPerson", method = RequestMethod.POST)
    public String createPerson(HttpServletRequest request, Model model) {
        // grab the incoming values from the form 
        // and create a new Person object
        Person p = new Person();
        p.setPersonName(request.getParameter("personName"));
        p.setPersonAge(request.getParameter("personAge"));
        p.setPersonTitle(request.getParameter("personTitle"));
        p.setPersonHTown(request.getParameter("personHTown"));

        // persist the new Person
        service.addPerson(p);

        // create an id for page to show info of what was just submitted
        long confirmedPerson = p.getPersonId();
        service.getPersonById(confirmedPerson);
        
        model.addAttribute("confirmedPerson", confirmedPerson);
        
        // Redirect View component
        return "redirect:displayConfirmationPage";
    }

    // delete for testing
    @RequestMapping(value = "/removePerson", method = RequestMethod.GET)
    public String removePerson(HttpServletRequest request) {
        String personIdParameter = request.getParameter("personId");
        long personId = Long.parseLong(personIdParameter);
        
        service.removePerson(personId);

        // Redirect View component
        return "redirect:displayHomePage";
    }
}
