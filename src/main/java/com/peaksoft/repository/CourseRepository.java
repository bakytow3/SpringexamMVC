package com.peaksoft.repository;


import com.peaksoft.model.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course);
    void updateCourse(Course course);
    List<Course> getAllCourse();
   Course getByIdCourse(Long id);
    void deleteByIdCourse(Long id);
}
