package com.cognizant.challenge.dto;

import lombok.Data;

@Data
public class SolutionResponseDto {
    private String output;
    private Integer statusCode;
    private String memory;
    private String cpuTime;
}
