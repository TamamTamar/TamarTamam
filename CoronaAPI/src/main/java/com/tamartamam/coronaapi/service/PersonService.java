package com.tamartamam.coronaapi.service;

import com.tamartamam.coronaapi.model.Person;
import com.tamartamam.coronaapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    public PersonRepository repository;

    public Iterable<Person> getAll() {
        return repository.findAll();
    }

    public Person getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Person getByFirstName(String firstName) {
        return repository.findByFirstName(firstName).orElse(null);
    }

    public Person getByLastName(String lastName) {
        return repository.findByLastName(lastName).orElse(null);
    }

    public Person getByFirstNameAndLastName(String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName, lastName).orElse(null);
    }

    public Person create(Person person) throws IllegalArgumentException {
        if (person.hasEmptyFields()) {
            throw new IllegalArgumentException("Cannot create Person with missing fields");
        }

        return this.repository.save(person);
    }

    public Person update(String id, Person person) throws IllegalArgumentException {
        if (person.getId() == null) {
            throw new IllegalArgumentException("Cannot update Person with missing id");
        }
        if (!this.repository.existsById(id)) {
            throw new IllegalArgumentException("Cannot update Person with non-existing id");
        }

        return this.repository.save(person);
    }

    public void delete(String id) {
        this.repository.deleteById(id);
    }
}
