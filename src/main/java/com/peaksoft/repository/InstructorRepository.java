package com.peaksoft.repository;


import com.peaksoft.model.Instructor;

import java.util.List;

public interface InstructorRepository {
    void saveInstructor(Instructor instructor);
    void updateInstructor(Instructor instructor);
    List<Instructor> getAllInstructor();
    Instructor getByIdInstructor(Long id);
    void deleteByIdInstructor(Long id);
}
