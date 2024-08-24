package com.zex.spring_security.services;

import com.zex.spring_security.domain.disease.Disease;
import com.zex.spring_security.domain.disease.DiseaseRequest;
import com.zex.spring_security.domain.disease.DiseaseResponse;
import com.zex.spring_security.repositories.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseaseService {
    @Autowired
    private DiseaseRepository repository;


    public DiseaseResponse save(DiseaseRequest data) {
        Disease newDisease = new Disease(data);

        return new DiseaseResponse(this.repository.save(newDisease));
    }


}
