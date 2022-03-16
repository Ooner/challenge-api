package com.cognizant.challenge.dto;

import lombok.Data;

@Data
public class SolutionRequestDto {
    private String clientId;
    private String clientSecret;
    private String script;
    private String versionIndex;
    private String language;
    private String userName;
    private Long taskId;
}
