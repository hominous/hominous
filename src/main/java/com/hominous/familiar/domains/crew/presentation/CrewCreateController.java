package com.hominous.familiar.domains.crew.presentation;

import com.hominous.familiar.domains.crew.application.CrewCreateService;
import com.hominous.familiar.domains.crew.application.dto.CrewCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CrewCreateController {

    private final CrewCreateService crewCreateService;

    @PostMapping("/crew")
    public ResponseEntity createCrew(CrewCreateRequest crewCreateRequest){
        crewCreateService.createCrew(crewCreateRequest);
        return ResponseEntity.ok().build();
    }
}
