package com.peaksoft.repository.impl;

import com.peaksoft.model.Lesson;
import com.peaksoft.model.Student;
import com.peaksoft.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class StudentImpl implements StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveStudent(Student student) {
        entityManager.persist(student);
        System.out.println("Student save successfully " +student);
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
        System.out.println("Student update successfully " + student);
    }

    @Override
    public List<Student> getAllStudent() {
        return entityManager.createQuery("select c from Student c", Student.class).getResultList();
    }

    @Override
    public Student getByIdStudent(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void deleteByIdStudent(Long id) {
        entityManager.remove(entityManager.find(Student.class, id));
    }
}
