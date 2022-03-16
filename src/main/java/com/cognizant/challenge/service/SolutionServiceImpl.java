package com.cognizant.challenge.service;

import com.cognizant.challenge.client.JDoodleClient;
import com.cognizant.challenge.converter.SolutionConverter;
import com.cognizant.challenge.dto.SolutionRequestDto;
import com.cognizant.challenge.dto.SolutionResponseDto;
import com.cognizant.challenge.dto.SolutionScoresDto;
import com.cognizant.challenge.entity.Solution;
import com.cognizant.challenge.entity.Task;
import com.cognizant.challenge.enums.SolutionStatus;
import com.cognizant.challenge.repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SolutionServiceImpl implements SolutionService {
    private final JDoodleClient jDoodleClient;
    private final TaskService taskService;
    private final SolutionConverter solutionConverter;
    private final SolutionRepository solutionRepository;

    @Value("${jdoodle.clientId}")
    private String clientId;

    @Value("${jdoodle.clientSecret}")
    private String clientSecret;

    public SolutionServiceImpl(JDoodleClient jDoodleClient, TaskService taskService, SolutionConverter solutionConverter, SolutionRepository solutionRepository) {
        this.jDoodleClient = jDoodleClient;
        this.taskService = taskService;
        this.solutionConverter = solutionConverter;
        this.solutionRepository = solutionRepository;
    }

    @Override
    public SolutionResponseDto execute(SolutionRequestDto request) {
        Optional<Task>  optTask = taskService.findById(request.getTaskId());
        if(optTask.isEmpty()){
            throw new RuntimeException("InValid Task");
        }

        request.setClientId(this.clientId);
        request.setClientSecret(this.clientSecret);
        request.setVersionIndex("0");
        SolutionResponseDto solutionResponseDto = jDoodleClient.executeTask(request);

        Solution solution = solutionConverter.convert(solutionResponseDto,optTask.get(),request);
        solutionRepository.save(solution);

        return solutionResponseDto;
    }

    @Override
    public List<SolutionScoresDto> findTopThreeScores() {
        List<Solution> solutions = solutionRepository.findAllByUserNameInAndStatusOrderByCpuTimeAscMemoryAsc();
        List<SolutionScoresDto> scoresDtos = new ArrayList<>();

        solutions.forEach(s -> {
            SolutionScoresDto solutionScoresDto;
            Optional<SolutionScoresDto> optScoresDto = scoresDtos.stream().filter(scoresDto -> scoresDto.getUserName().equals(s.getUserName())).findFirst();
            if(optScoresDto.isPresent() && !optScoresDto.get().getTaskIds().contains(s.getTask().getId())){
                solutionScoresDto = optScoresDto.get();
                solutionScoresDto.setNumberOfSuccessSolutions(solutionScoresDto.getNumberOfSuccessSolutions()+1);
                solutionScoresDto.setTasksName(solutionScoresDto.getTasksName() + ","+ s.getTask().getName());
            } else {
                solutionScoresDto = new SolutionScoresDto();
                solutionScoresDto.setUserName(s.getUserName());
                solutionScoresDto.setNumberOfSuccessSolutions(1);
                solutionScoresDto.setTasksName(s.getTask().getName());
                ArrayList<Long> taskIds = new ArrayList<>();
                taskIds.add(s.getTask().getId());
                solutionScoresDto.setTaskIds(taskIds);
                scoresDtos.add(solutionScoresDto);
            }
        });

        return scoresDtos;
    }
}
