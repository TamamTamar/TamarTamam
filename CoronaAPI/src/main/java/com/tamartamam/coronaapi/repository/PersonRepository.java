package com.tamartamam.coronaapi.repository;

import com.tamartamam.coronaapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {
    Optional<Person> findByFirstName(String firstName);

    Optional<Person> findByLastName(String lastName);

    Optional<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
