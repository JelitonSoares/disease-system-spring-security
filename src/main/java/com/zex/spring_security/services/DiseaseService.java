package com.zex.spring_security.services;

import com.zex.spring_security.domain.disease.Disease;
import com.zex.spring_security.domain.disease.DiseaseRequest;
import com.zex.spring_security.domain.disease.DiseaseResponse;
import com.zex.spring_security.repositories.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiseaseService {
    @Autowired
    private DiseaseRepository repository;


    public Disease save(DiseaseRequest data) {
        Disease newDisease = new Disease(data);

        return this.repository.save(newDisease);
    }


    public Page<DiseaseResponse> getAll(Pageable pageable) {
        Page<Disease> diseases = this.repository.findAll(pageable);

        return diseases.map(d -> new DiseaseResponse(d));
    }

    public DiseaseResponse details(String id) {
        return new DiseaseResponse(this.repository.getReferenceById(id));
    }


}
