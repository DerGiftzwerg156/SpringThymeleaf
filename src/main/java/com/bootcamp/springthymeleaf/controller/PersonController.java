package com.bootcamp.springthymeleaf.controller;

import com.bootcamp.springthymeleaf.entities.Person;
import com.bootcamp.springthymeleaf.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/showAll")
    public String showAllPersons(Model model) {
        personService.createPersons();
        ArrayList<Person> persons = personService.getAllPersons();
        model.addAttribute("persons", persons);
        return "displayAllPersons";
    }

    @GetMapping("/createForm")
    public String showPersonCreateForm(Model model) {
        model.addAttribute("newPerson", new Person());
        return "personCreateForm";
    }

    @PostMapping("/saveNewPerson")
    public String saveNewPerson(Person person) {
        personService.createNewPerson(person);
        return "redirect:/person/showAll";
    }

    @PostMapping("/deletePerson")
    public String deletePerson(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        personService.deletePersonByFirstAndLastName(firstName, lastName);
        return "redirect:/person/showAll";
    }
}
