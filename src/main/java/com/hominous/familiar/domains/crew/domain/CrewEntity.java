package com.hominous.familiar.domains.crew.domain;


import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Getter
@Table(name = "crew")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CrewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String createdBy;

    @Builder
    public CrewEntity(String name, String createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }
}
