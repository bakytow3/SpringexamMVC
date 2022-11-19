package com.peaksoft.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "students")
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private StudyFormat studyFormat;

    public Student(String firstName, String lastName, String phoneNumber, String email, StudyFormat studyFormat) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.studyFormat = studyFormat;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Group groups;
}