package com.hominous.familiar.domain.member.service;


import com.hominous.familiar.domain.crew.domain.CrewEntity;
import com.hominous.familiar.domain.crew.domain.CrewRepository;
import com.hominous.familiar.domain.member.dto.MemberCreateCrewRequest;
import com.hominous.familiar.domain.member.domain.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCreateCrewService {

  private final CrewRepository crewRepository;
  private final MemberFindService memberFindService;

  public CrewEntity makeCrew(Long memberIndex, MemberCreateCrewRequest memberCreateCrewRequest) {
    MemberEntity memberEntity = memberFindService.findById(memberIndex);
    CrewEntity crewEntity = CrewEntity
        .builder()
        .name(memberCreateCrewRequest.getName())
        .createdBy(memberEntity.getName())
        .build();
    return crewRepository.save(crewEntity);
  }
}
