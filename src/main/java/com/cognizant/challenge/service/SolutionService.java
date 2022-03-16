package com.cognizant.challenge.service;

import com.cognizant.challenge.dto.SolutionRequestDto;
import com.cognizant.challenge.dto.SolutionResponseDto;
import com.cognizant.challenge.dto.SolutionScoresDto;

import java.util.List;

public interface SolutionService {
    SolutionResponseDto execute(SolutionRequestDto request);
    List<SolutionScoresDto> findTopThreeScores();
}
