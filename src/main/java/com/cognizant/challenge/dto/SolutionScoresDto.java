package com.cognizant.challenge.dto;

import lombok.Data;

import java.util.List;

@Data
public class SolutionScoresDto {
    private String userName;
    private String tasksName;
    private Integer numberOfSuccessSolutions;
    private List<Long> taskIds;
}
