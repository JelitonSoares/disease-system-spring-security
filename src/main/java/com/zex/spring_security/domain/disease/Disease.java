package com.zex.spring_security.domain.disease;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "diseases")
@Entity(name = "disease")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")


public class Disease {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String cid;

    private String name;

    private String symptoms;

    private String treatments;

    private Integer risk;


    public Disease(DiseaseRequest data) {
        this.cid = data.cid();
        this.name = data.name();
        this.symptoms = data.symptoms();
        this.treatments = data.treatments();
        this.risk = data.risk();
    }
}
