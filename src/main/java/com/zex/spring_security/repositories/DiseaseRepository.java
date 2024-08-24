package com.zex.spring_security.repositories;

import com.zex.spring_security.domain.disease.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiseaseRepository extends JpaRepository<Disease, String> {

    List<Disease> findBySymptomsContainingIgnoreCase(String Symptoms);
}
