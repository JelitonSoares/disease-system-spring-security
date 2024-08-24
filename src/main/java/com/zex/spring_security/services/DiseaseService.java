package com.zex.spring_security.services;

import com.zex.spring_security.repositories.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseaseService {
    @Autowired
    private DiseaseRepository repository;





}
