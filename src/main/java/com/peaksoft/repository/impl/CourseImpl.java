package com.peaksoft.repository.impl;

import com.peaksoft.model.Company;
import com.peaksoft.model.Course;
import com.peaksoft.repository.CourseRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class CourseImpl implements CourseRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveCourse(Course course) {
        entityManager.persist(course);
        System.out.println("Course save successfully " +course);
    }

    @Override
    public void updateCourse(Course course) {
        entityManager.merge(course);
        System.out.println("Course update successfully " + course);
    }

    @Override
    public List<Course> getAllCourse() {

        return entityManager.createQuery("select c from Course c", Course.class).getResultList();
    }

    @Override
    public Course getByIdCourse(Long id) {

        return entityManager.find(Course.class, id);
    }

    @Override
    public void deleteByIdCourse(Long id) {
        entityManager.remove(entityManager.find(Course.class, id));
    }
}
