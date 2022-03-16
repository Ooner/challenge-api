package com.cognizant.challenge.client;

import com.cognizant.challenge.dto.SolutionRequestDto;
import com.cognizant.challenge.dto.SolutionResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "jDoddleClientApi", url = "https://api.jdoodle.com/v1")
public interface JDoodleClient {

    @PostMapping(value = "/execute")
    SolutionResponseDto executeTask(SolutionRequestDto solutionRequestDto);

}