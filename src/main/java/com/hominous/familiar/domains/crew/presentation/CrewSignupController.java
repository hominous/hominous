package com.hominous.familiar.domains.crew.presentation;

import com.hominous.familiar.domains.crew.application.CrewSignupService;
import com.hominous.familiar.domains.crew.application.dto.CrewSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CrewSignupController {

    private final CrewSignupService crewSignupService;

    @PostMapping("/crew")
    public ResponseEntity createCrew(CrewSignupRequest crewSignupRequest){
        crewSignupService.createCrew(crewSignupRequest);
        return ResponseEntity.ok().build();
    }
}
