package com.peaksoft.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
@NoArgsConstructor
@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String email;

    private String specialization;

    public Instructor(String firstName, String lastName, String phoneNumber, String email, String specialization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.specialization = specialization;

    }

    @ManyToOne (cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH},fetch = FetchType.EAGER)
    private Course courses;

}
