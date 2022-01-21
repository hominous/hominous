package com.hominous.familiar.domains.member.presentation;


import com.hominous.familiar.domains.crew.domain.CrewEntity;
import com.hominous.familiar.domains.member.application.MemberCreateCrewService;
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
      @RequestBody String name){
    CrewEntity crewEntity = memberCreateCrewService.makeCrew(memberIndex, name);
    return ResponseEntity.ok(crewEntity);
  }
}
