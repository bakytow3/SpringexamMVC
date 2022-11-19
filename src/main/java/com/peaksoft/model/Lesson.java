package com.peaksoft.model;

import javax.persistence.*;
import java.util.List;

@Entity

@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lessonName;


    public Lesson(String lessonName) {
        this.lessonName = lessonName;
    }

    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH},fetch = FetchType.EAGER)
    private Course course;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "lesson")
private List<Task>tasks;

    public Lesson() {

    }
}