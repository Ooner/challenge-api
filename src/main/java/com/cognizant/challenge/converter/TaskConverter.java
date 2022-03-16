package com.cognizant.challenge.converter;

import com.cognizant.challenge.dto.TaskDto;
import com.cognizant.challenge.entity.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskConverter {
    public  TaskDto convert(Task task) {
        return  TaskDto.builder()
                .id(task.getId())
                .description(task.getDescription())
                .name(task.getName())
                .parameter(task.getParameter())
                .output(task.getOutput()).build();
    }

    public List<TaskDto> convert(List<Task> tasks) {
        return tasks.stream().map(this::convert).collect(Collectors.toList());
    }
}
