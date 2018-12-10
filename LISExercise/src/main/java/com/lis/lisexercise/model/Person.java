/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lis.lisexercise.model;

import java.util.Objects;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Chad
 */
public class Person {

    long personId;
    @NotEmpty(message = "You must supply a value for the Name.")
    @Length(max = 30, message = "Name must be no more than 30 characters in length.")
    String personName;
    @Length(max = 3, message = "Age must be no more than 3 numbers in length.")
    String personAge;
    @NotEmpty(message = "You must supply a value for the Title.")
    @Length(max = 30, message = "Title must be no more than 30 characters in length.")
    String personTitle;
    @Length(max = 30, message = "Hometown must be no more than 45 characters in length.")
    String personHTown;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonAge() {
        return personAge;
    }

    public void setPersonAge(String personAge) {
        this.personAge = personAge;
    }

    public String getPersonTitle() {
        return personTitle;
    }

    public void setPersonTitle(String personTitle) {
        this.personTitle = personTitle;
    }

    public String getPersonHTown() {
        return personHTown;
    }

    public void setPersonHTown(String personHTown) {
        this.personHTown = personHTown;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.personId ^ (this.personId >>> 32));
        hash = 89 * hash + Objects.hashCode(this.personName);
        hash = 89 * hash + Objects.hashCode(this.personAge);
        hash = 89 * hash + Objects.hashCode(this.personTitle);
        hash = 89 * hash + Objects.hashCode(this.personHTown);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.personId != other.personId) {
            return false;
        }
        if (!Objects.equals(this.personName, other.personName)) {
            return false;
        }
        if (!Objects.equals(this.personAge, other.personAge)) {
            return false;
        }
        if (!Objects.equals(this.personTitle, other.personTitle)) {
            return false;
        }
        if (!Objects.equals(this.personHTown, other.personHTown)) {
            return false;
        }
        return true;
    }

    
}
