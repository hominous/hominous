package com.hominous.familiar.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CrewCreateDto {
    private String name;
    private String createdBy;

    public CrewCreateDto(String name, String createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }
}