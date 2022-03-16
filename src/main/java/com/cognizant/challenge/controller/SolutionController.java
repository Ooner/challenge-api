package com.cognizant.challenge.controller;

import com.cognizant.challenge.dto.SolutionRequestDto;
import com.cognizant.challenge.dto.SolutionResponseDto;
import com.cognizant.challenge.dto.SolutionScoresDto;
import com.cognizant.challenge.service.SolutionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SolutionController {

    private final SolutionService solutionService;

    public SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @PostMapping("api/execute")
    public SolutionResponseDto execute(@RequestBody SolutionRequestDto request) {
        return  solutionService.execute(request);
    }

    @GetMapping("api/scores")
    public List<SolutionScoresDto> findTopThreeScores() {
        return  solutionService.findTopThreeScores();
    }
}
