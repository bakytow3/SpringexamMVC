package com.peaksoft.repository.impl;

import com.peaksoft.model.Instructor;
import com.peaksoft.model.Lesson;
import com.peaksoft.repository.LessonRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class LessonImpl implements LessonRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveLesson(Lesson lesson) {
        entityManager.persist(lesson);
        System.out.println("Lesson save successfully " +lesson);
    }

    @Override
    public void updateLesson(Lesson lesson) {
        entityManager.merge(lesson);
        System.out.println("Lesson update successfully " + lesson);
    }

    @Override
    public List<Lesson> getAllLesson() {
        return entityManager.createQuery("select c from Lesson c", Lesson.class).getResultList();
    }

    @Override
    public Lesson getByIdLesson(Long id) {
        return entityManager.find(Lesson.class, id);
    }

    @Override
    public void deleteByIdLesson(Long id) {
        entityManager.remove(entityManager.find(Lesson.class, id));
    }
}
