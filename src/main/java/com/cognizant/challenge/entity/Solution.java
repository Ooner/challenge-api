package com.cognizant.challenge.entity;

import com.cognizant.challenge.enums.SolutionStatus;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Solution {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(targetEntity = Task.class, fetch = FetchType.LAZY)
    private Task task;
    private String userName;
    private String output;
    private String memory;
    private String cpuTime;
    private String language;
    private String script;
    private String versionIndex;
    @Enumerated(EnumType.STRING)
    private SolutionStatus status;
}
