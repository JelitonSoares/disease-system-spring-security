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
        this.symptoms = data.symptoms().toString();
        this.treatments = data.treatments().toString();
        this.risk = data.risk();
    }

    public void update(DiseaseUpdateDTO data) {
        if(data.cid() != null) {
            this.cid = data.cid();
        }

        if(data.name() != null) {
            this.name = data.name();
        }

        if(data.symptoms() != null) {
            this.symptoms = data.symptoms();
        }

        if(data.treatments() != null) {
            this.treatments = data.treatments();
        }

        if(data.risk() != null) {
            this.risk = data.risk();
        }
    }
}
