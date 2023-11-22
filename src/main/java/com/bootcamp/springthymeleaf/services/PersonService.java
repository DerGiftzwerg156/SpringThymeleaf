package com.bootcamp.springthymeleaf.services;

import com.bootcamp.springthymeleaf.entities.Person;
import com.bootcamp.springthymeleaf.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ArrayList<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person findPersonByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    public void createNewPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePersonByFirstAndLastName(String firstName, String lastName) {
        personRepository.deleteByFirstNameAndLastName(firstName, lastName);
    }

    public void createPersons() {
        Person person1 = new Person("Keno", "Dirks", 22);
        Person person2 = new Person("Maniel", "Deyer", 30);
        Person person3 = new Person("Bob", "Boobie", 16);
        createNewPerson(person1);
        createNewPerson(person2);
        createNewPerson(person3);
    }

}
