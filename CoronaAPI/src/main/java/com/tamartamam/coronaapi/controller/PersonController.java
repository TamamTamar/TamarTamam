package com.tamartamam.coronaapi.controller;

import com.tamartamam.coronaapi.model.Person;
import com.tamartamam.coronaapi.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/person", produces = "application/json")
public class PersonController {

    private final PersonService service;

    PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Person> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable("id") String id) {
        return this.service.getById(id);
    }

    @GetMapping("/firstName/{firstName}")
    public Person getByFirstName(@PathVariable("firstName") String firstName) {
        return this.service.getByFirstName(firstName);
    }

    @GetMapping("/lastName/{lastName}")
    public Person getByLastName(@PathVariable("lastName") String lastName) {
        return this.service.getByLastName(lastName);
    }

    @GetMapping("/name/{firstName}/{lastName}")
    public Person getByFirstNameAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
        return this.service.getByFirstNameAndLastName(firstName, lastName);
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        try {
            return this.service.create(person);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable("id") String id, @RequestBody Person person) {
        try {
            return this.service.update(id, person);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        this.service.delete(id);
    }
}
