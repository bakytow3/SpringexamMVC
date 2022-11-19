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
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    private String dateOfStart;

    private String image;

    public Group(String groupName, String dateOfStart, String image) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.image = image;

    }

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.LAZY)
    private List<Course>courses;
    @OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.LAZY,mappedBy = "groups")
    private List<Student>students;
}
