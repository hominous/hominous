package com.hominous.familiar.domain.auth.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Table(name = "authority")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AuthorityEntity {

    @Id
    @Column(name = "authority_name")
    private String authorityName;

}
