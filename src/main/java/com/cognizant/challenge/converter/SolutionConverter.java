package com.cognizant.challenge.converter;

import com.cognizant.challenge.dto.SolutionRequestDto;
import com.cognizant.challenge.dto.SolutionResponseDto;
import com.cognizant.challenge.entity.Solution;
import com.cognizant.challenge.entity.Task;
import com.cognizant.challenge.enums.SolutionStatus;
import org.springframework.stereotype.Component;

@Component
public class SolutionConverter {
    public Solution convert(SolutionResponseDto solutionResponseDto, Task task,SolutionRequestDto solutionRequestDto) {
        Solution solution = new Solution();
        solution.setCpuTime(solutionResponseDto.getCpuTime());
        solution.setMemory(solutionResponseDto.getMemory());
        solution.setOutput(solutionResponseDto.getOutput());
        solution.setStatus(solutionResponseDto.getStatusCode() == 200 ? SolutionStatus.SUCCESS: SolutionStatus.FAIL);
        solution.setTask(task);
        solution.setLanguage(solutionRequestDto.getLanguage());
        solution.setUserName(solutionRequestDto.getUserName());
        solution.setScript(solutionRequestDto.getScript());
        solution.setVersionIndex(solutionRequestDto.getVersionIndex());
        return solution;
    }
}
