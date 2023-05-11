package com.tamartamam.coronaapi.controller;

import com.tamartamam.coronaapi.model.Provider;
import com.tamartamam.coronaapi.service.ProviderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "/provider", produces = "application/json")
public class ProviderController {

    private final ProviderService service;

    ProviderController(ProviderService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Provider> getAll() {
        return this.service.getAll();
    }

    @GetMapping("/{id}")
    public Provider getById(@PathVariable("id") Long id) {
        return this.service.getById(id);
    }

    @PostMapping
    public Provider create(@RequestBody Provider provider) {
        try {
            return this.service.create(provider);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Provider update(@PathVariable("id") Long id, @RequestBody Provider provider) {
        try {
            return this.service.update(id, provider);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.service.delete(id);
    }
}