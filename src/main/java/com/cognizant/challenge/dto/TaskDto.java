package com.cognizant.challenge.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDto {
    private Long id;
    private String name;
    private String description;
    private String parameter;
    private String output;
}
