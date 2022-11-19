package com.peaksoft.service.impl;

import com.peaksoft.model.Course;
import com.peaksoft.repository.CourseRepository;
import com.peaksoft.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public void saveCourse(Course course) {
courseRepository.saveCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
courseRepository.updateCourse(course);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    @Override
    public Course getByIdCourse(Long id) {
        return courseRepository.getByIdCourse(id);
    }

    @Override
    public void deleteByIdCourse(Long id) {
courseRepository.deleteByIdCourse(id);
    }
}
