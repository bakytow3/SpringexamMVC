package com.peaksoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    private String locatedCountry;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "company")
    private List<Course>courses;
    public void addCourses(Course course){

        if (courses==null){
            courses=new ArrayList<>();
        }
        courses.add(course);
    }

    public Company(String companyName, String locatedCountry) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;

    }
}
