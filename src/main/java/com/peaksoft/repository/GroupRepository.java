package com.peaksoft.repository;


import com.peaksoft.model.Group;

import java.util.List;

public interface GroupRepository {
    void saveGroup(Group group);
    void updateGroup(Group group);
    List<Group> getAllGroup();
    Group getByIdGroup(Long id);
    void deleteByIdGroup(Long id);
}
