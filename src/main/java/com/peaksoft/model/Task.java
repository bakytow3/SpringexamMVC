package com.peaksoft.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;
    private String taskText;
    private String deadline;

    public Task(String taskName, String taskText, String deadline) {
        this.taskName = taskName;
        this.taskText = taskText;
        this.deadline = deadline;
    }

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.EAGER)
    private Lesson lesson;
}

