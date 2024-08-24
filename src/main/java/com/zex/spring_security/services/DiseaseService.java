package com.zex.spring_security.services;

import com.zex.spring_security.domain.disease.Disease;
import com.zex.spring_security.domain.disease.DiseaseRequest;
import com.zex.spring_security.domain.disease.DiseaseResponse;
import com.zex.spring_security.repositories.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiseaseService {
    @Autowired
    private DiseaseRepository repository;


    public DiseaseResponse save(DiseaseRequest data) {
        Disease newDisease = new Disease(data);

        return new DiseaseResponse(this.repository.save(newDisease));
    }


    public List<DiseaseResponse> getAll() {
        List<Disease> diseases = this.repository.findAll();

        return diseases.stream()
                .map(d -> new DiseaseResponse(d))
                .collect(Collectors.toList());
    }


}
