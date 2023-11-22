package com.bootcamp.springthymeleaf.repositories;

import com.bootcamp.springthymeleaf.entities.Person;

import java.util.ArrayList;

public interface PersonRepo {
    ArrayList<Person> findAll();

    Person findByFirstName(String firstName);

    void save(Person person);

    void deleteByFirstNameAndLastName(String firstName, String lastName);
}
