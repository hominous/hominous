package com.hominous.familiar.domains.crew.application.dto;


import lombok.Getter;

@Getter
public class CrewCreateRequest {
    private final String name;
    private final String createdBy;

    public CrewCreateRequest(String name, String createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }
}
