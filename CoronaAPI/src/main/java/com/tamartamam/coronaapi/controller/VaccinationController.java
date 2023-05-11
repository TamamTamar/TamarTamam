package com.tamartamam.coronaapi.controller;

import com.tamartamam.coronaapi.model.Vaccination;
import com.tamartamam.coronaapi.service.VaccinationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/vaccination", produces = "application/json")
public class VaccinationController {

    private final VaccinationService service;

    VaccinationController(VaccinationService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Vaccination> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Vaccination getById(@PathVariable("id") Long id) {
        return this.service.getById(id);
    }

    @GetMapping("/person/{id}")
    public Iterable<Vaccination> getByPersonId(@PathVariable("id") String id) {
        return this.service.getByPersonId(id);
    }

    @GetMapping("/provider/{id}")
    public Iterable<Vaccination> getByProviderId(@PathVariable("id") Long id) {
        return this.service.getByProviderId(id);
    }

    @PostMapping
    public Vaccination create(@RequestBody Vaccination vaccination) {
        try {
            return this.service.create(vaccination);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Vaccination update(@PathVariable("id") Long id, @RequestBody Vaccination vaccination) {
        try {
            return this.service.update(id, vaccination);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.service.delete(id);
    }
}
