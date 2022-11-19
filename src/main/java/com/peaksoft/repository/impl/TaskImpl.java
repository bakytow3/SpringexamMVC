package com.peaksoft.repository.impl;

import com.peaksoft.model.Student;
import com.peaksoft.model.Task;
import com.peaksoft.repository.TaskRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class TaskImpl implements TaskRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void saveTask(Task task) {
        entityManager.persist(task);
        System.out.println("Task save successfully " +task);
    }

    @Override
    public void updateTask(Task task) {
        entityManager.merge(task);
        System.out.println("Task update successfully " + task);
    }

    @Override
    public List<Task> getAllTask() {
        return entityManager.createQuery("select c from Task c", Task.class).getResultList();
    }

    @Override
    public Task getByIdTask(Long id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public void deleteByIdTask(Long id) {
        entityManager.remove(entityManager.find(Task.class, id));
    }
}
