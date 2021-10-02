package com.hominous.familiar.crew.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
public class Crew {
    @Setter
    private Long id;

    private String name;
    private String createdBy;

    public Crew(String name, String createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }
}
