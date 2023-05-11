package com.tamartamam.coronaapi.service;

import com.tamartamam.coronaapi.model.Provider;
import com.tamartamam.coronaapi.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {
    @Autowired
    public ProviderRepository repository;

    public Iterable<Provider> getAll() {
        return repository.findAll();
    }

    public Provider getById(long id) {
        return repository.findById(id).orElse(null);
    }

    public Provider create(Provider provider) throws IllegalArgumentException {
        if (provider.getId() == null || provider.getName() == null) {
            throw new IllegalArgumentException("Cannot create Provider with missing fields");
        }

        return this.repository.save(provider);
    }

    public Provider update(long id, Provider provider) throws IllegalArgumentException {
        if (provider.getId() == null) {
            throw new IllegalArgumentException("Cannot update Provider with missing id");
        }
        if (!this.repository.existsById(id)) {
            throw new IllegalArgumentException("Cannot update Provider with non-existing id");
        }

        return this.repository.save(provider);
    }

    public void delete(long id) {
        this.repository.deleteById(id);
    }
}
