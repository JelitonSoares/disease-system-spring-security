package com.zex.spring_security.domain.disease;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DiseaseRequest(@NotBlank String cid,
                             @NotBlank
                             String name,
                             @NotNull
                             List<String> symptoms,
                             @NotNull
                             List<String> treatments,
                             @NotNull
                             Integer risk) {
}
