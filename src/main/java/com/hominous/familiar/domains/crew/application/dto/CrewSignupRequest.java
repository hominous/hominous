package com.hominous.familiar.domains.crew.application.dto;


import lombok.Getter;

@Getter
public class CrewSignupRequest {
    private final String name;
    private final String createdBy;

    public CrewSignupRequest(String name, String createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }
}
