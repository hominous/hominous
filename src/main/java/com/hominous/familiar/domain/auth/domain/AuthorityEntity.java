package com.hominous.familiar.domain.auth.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Builder
@Table(name = "authority")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class AuthorityEntity {

    @Id
    @Column(name = "authority_name")
    private String authorityName;

}
