package com.cognizant.challenge.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String parameter;
    private String output;
}
