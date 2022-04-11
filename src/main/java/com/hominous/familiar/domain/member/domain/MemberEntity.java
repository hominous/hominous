package com.hominous.familiar.domain.member.domain;


import com.hominous.familiar.domain.BaseTimeEntity;
import com.hominous.familiar.domain.auth.domain.AuthorityEntity;
import com.hominous.familiar.domain.crew.domain.CrewEntity;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Getter
@Builder
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class MemberEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String memberId;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String birthdate;

    @ManyToMany
    @JoinTable(
        name = "member_crew",
        joinColumns = {@JoinColumn(name = "member_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "crew_id", referencedColumnName = "id")})
    private List<CrewEntity> crewEntities;

    @ManyToMany
    @JoinTable(
            name = "member_authority",
            joinColumns = {@JoinColumn(name = "member_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<AuthorityEntity> authorityEntities;


    public void addAuthority(AuthorityEntity authority){
        this.authorityEntities.add(authority);
    }

    public CrewEntity addCrew(CrewEntity crewEntity) {
        this.crewEntities.add(crewEntity);
        return crewEntity;
    }
}


