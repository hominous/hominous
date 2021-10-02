package com.hominous.familiar.crew.controller;


import com.hominous.familiar.crew.domain.Crew;
import com.hominous.familiar.crew.repository.CrewRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/crew")
public class CrewController {
    CrewRepository crewRepository = CrewRepository.getInstance();

    @GetMapping("/new")
    public String createForm() {return "crew/create-form";}

    @PostMapping
    public String createCrew(String name,String createdBy, Model model){
        Crew crew = new Crew(name,createdBy);
        crewRepository.save(crew);
        model.addAttribute("crew",crew);
        return "crew/welcome";
    }
}
