package com.cognizant.challenge.service;

import com.cognizant.challenge.entity.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAll();
    Optional<Task> findById(Long id);
    void save(Task task);
}
