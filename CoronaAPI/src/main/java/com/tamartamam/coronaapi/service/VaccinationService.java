package com.tamartamam.coronaapi.service;

import com.tamartamam.coronaapi.model.Vaccination;
import com.tamartamam.coronaapi.repository.VaccinationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VaccinationService {

    @Autowired
    public VaccinationRepository repository;

    public Iterable<Vaccination> getAll() {
        return this.repository.findAll();
    }

    public Vaccination getById(long id) {
        return this.repository.findById(id).orElse(null);
    }

    public Iterable<Vaccination> getByPersonId(String id) {
        return this.repository.findByPersonId(id);
    }

    public Iterable<Vaccination> getByProviderId(long id) {
        return this.repository.findByProviderId(id);
    }

    public Vaccination create(Vaccination vaccination) throws IllegalArgumentException {
        if (vaccination.getId() != null) {
            throw new IllegalArgumentException("Cannot create Vaccination with existing id");
        }

        return this.repository.save(vaccination);
    }

    public Vaccination update(long id, Vaccination vaccination) throws IllegalArgumentException {
        if (vaccination.getId() == null) {
            throw new IllegalArgumentException("Cannot update Vaccination with missing id");
        }
        if (!this.repository.existsById(id)) {
            throw new EntityNotFoundException("Cannot update Vaccination with non-existing id");
        }

        return this.repository.save(vaccination);
    }

    public void delete(long id) {
        this.repository.deleteById(id);
    }
}
