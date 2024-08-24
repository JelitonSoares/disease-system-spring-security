package com.zex.spring_security.domain.disease;

public record DiseaseRequest(String cid,
                             String name,
                             String symptoms,
                             String treatments,
                             Integer risk) {
}
