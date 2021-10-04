package com.hominous.familiar.crew.dto;


import lombok.Getter;

@Getter
public class CrewCreateDto {
    private final String name;
    private final String createdBy;

    public CrewCreateDto(String name, String createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }
}
