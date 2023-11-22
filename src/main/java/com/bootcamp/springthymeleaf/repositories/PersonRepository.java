package com.bootcamp.springthymeleaf.repositories;

import com.bootcamp.springthymeleaf.entities.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class PersonRepository implements PersonRepo {

    private ArrayList<Person> persons = new ArrayList<>();


    @Override
    public ArrayList<Person> findAll() {
        return persons;
    }

    @Override
    public Person findByFirstName(String firstName) {
        return persons.stream().filter(e -> e.getFirstName().equals(firstName)).findFirst().orElse(null);
    }

    @Override
    public void save(Person person) {
        persons.add(person);
    }

    @Override
    public void deleteByFirstNameAndLastName(String firstName, String lastName) {
        persons.removeIf(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName));
    }
}
