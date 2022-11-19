package com.peaksoft.repository;
import com.peaksoft.model.Task;

import java.util.List;

public interface TaskRepository {
    void saveTask(Task task);
    void updateTask(Task task);
    List<Task> getAllTask();
    Task getByIdTask(Long id);
    void deleteByIdTask(Long id);
}
