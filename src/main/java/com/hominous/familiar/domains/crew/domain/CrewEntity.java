package com.hominous.familiar.domains.crew.domain;


import com.hominous.familiar.domains.member.domain.MemberEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CrewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String createdBy;

    @Builder
    public CrewEntity(String name, String createdBy) {
        this.name = name;
        this.createdBy = createdBy;
    }
}
