package com.zex.spring_security.domain.disease;

public record DiseaseResponse(String id,
                              String cid,
                              String name,
                              String symptoms,
                              String treatments,
                              Integer risk) {
}
