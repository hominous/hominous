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
    // TODO: 2022/04/10 Sign-in 처럼 로직수정 
    CrewEntity crewEntity = CrewEntity
        .builder()
        .name(memberCreateCrewRequest.getName())
        .createdBy(memberEntity.getName())
        .crewType(memberCreateCrewRequest.getCrewType())
        .build();
    return crewRepository.save(crewEntity);
  }
}
