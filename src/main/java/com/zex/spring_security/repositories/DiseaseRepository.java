package com.zex.spring_security.repositories;

import com.zex.spring_security.domain.disease.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DiseaseRepository extends JpaRepository<Disease, String> {

    List<Disease> findBySymptomsContainingIgnoreCase(String Symptoms);

    List<Disease> findByCidContainingIgnoreCase(String cid);

    List<Disease> findByNameContainingIgnoreCase(String name);
}
