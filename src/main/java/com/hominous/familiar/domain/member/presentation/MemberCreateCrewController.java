package com.hominous.familiar.domain.member.presentation;


import com.hominous.familiar.domain.crew.domain.CrewEntity;
import com.hominous.familiar.domain.member.application.MemberCreateCrewService;
import com.hominous.familiar.domain.member.application.dto.MemberCreateCrewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberCreateCrewController {

  private final MemberCreateCrewService memberCreateCrewService;

  @PostMapping("/member/{memberIndex}/crew")
  public ResponseEntity<CrewEntity> makeCrew(
      @PathVariable Long memberIndex,
      @RequestBody MemberCreateCrewRequest memberCreateCrewRequest){
    CrewEntity crewEntity = memberCreateCrewService.makeCrew(memberIndex, memberCreateCrewRequest);
    return ResponseEntity.ok(crewEntity);
  }
}
