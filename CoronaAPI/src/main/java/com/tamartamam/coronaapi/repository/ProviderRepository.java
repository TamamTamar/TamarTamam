package com.tamartamam.coronaapi.repository;

import com.tamartamam.coronaapi.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
