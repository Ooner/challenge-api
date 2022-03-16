package com.cognizant.challenge.controller;

import com.cognizant.challenge.converter.TaskConverter;
import com.cognizant.challenge.dto.TaskDto;
import com.cognizant.challenge.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;
    private final TaskConverter taskConverter;

    public TaskController(TaskService taskService, TaskConverter taskConverter) {
        this.taskService = taskService;
        this.taskConverter = taskConverter;
    }

    @GetMapping("api/task")
    public List<TaskDto> getTasks() {
        return  taskConverter.convert(this.taskService.getAll());
    }

}
