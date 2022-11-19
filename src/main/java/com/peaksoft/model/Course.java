package com.peaksoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "courses")

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private String duration;

    private String description;

    public Course(String courseName, String duration, String description, Company company, List<Group> groups, List<Instructor> instructors, List<Lesson> lessons) {
        this.courseName = courseName;
        this.duration = duration;
        this.description = description;


    }

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.EAGER)
private Company company;
@ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.LAZY,mappedBy = "courses")
    private List<Group>groups;
@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE},fetch = FetchType.LAZY,mappedBy = "courses")
private List<Instructor> instructors;
@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.REMOVE},fetch = FetchType.LAZY,mappedBy = "course")
    private List<Lesson>lessons;
}

