package com.tamartamam.coronaapi.repository;

import com.tamartamam.coronaapi.model.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {
    Iterable<Vaccination> findByPersonId(String id);

    Iterable<Vaccination> findByProviderId(long id);
}
