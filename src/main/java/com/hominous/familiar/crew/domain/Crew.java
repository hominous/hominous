package com.hominous.familiar.crew.domain;


import com.hominous.familiar.domains.crew.application.dto.CrewCreateRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
public class Crew {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String createdBy;

    public Crew(){}

    public Crew(CrewCreateRequest crewCreateDto) {
        this.name = crewCreateDto.getName();
        this.createdBy = crewCreateDto.getCreatedBy();
    }
}
