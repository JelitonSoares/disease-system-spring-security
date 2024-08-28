package com.zex.spring_security.domain.disease;

import jakarta.validation.constraints.NotBlank;

public record DiseaseUpdateDTO(@NotBlank String id, String cid, String name, String symptoms, String treatments, Integer risk) {

    public DiseaseUpdateDTO(Disease disease) {
        this(disease.getId(), disease.getCid(), disease.getName(), disease.getSymptoms(), disease.getTreatments(), disease.getRisk());
    }
}
