package com.peaksoft.repository;

import com.peaksoft.model.Lesson;

import java.util.List;

public interface LessonRepository {
    void saveLesson(Lesson lesson);
    void updateLesson(Lesson lesson);
    List<Lesson> getAllLesson();
    Lesson getByIdLesson(Long id);
    void deleteByIdLesson(Long id);
}
