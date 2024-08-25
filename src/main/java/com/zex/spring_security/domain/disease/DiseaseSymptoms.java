package com.zex.spring_security.domain.disease;

import jakarta.validation.constraints.NotNull;

public record DiseaseSymptoms(@NotNull String symptoms) {
}
