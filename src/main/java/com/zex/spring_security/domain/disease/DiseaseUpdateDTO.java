package com.zex.spring_security.domain.disease;

public record DiseaseUpdateDTO(String id, String cid, String name, String symptoms, String treatments, Integer risk) {

    DiseaseUpdateDTO(Disease disease) {
        this(disease.getId(), disease.getCid(), disease.getName(), disease.getSymptoms(), disease.getTreatments(), disease.getRisk());
    }
}
