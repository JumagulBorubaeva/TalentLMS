package com.peaksoft.dao;

import com.peaksoft.entity.Group;

import java.util.List;

public interface GroupDAO {
    List<Group>getAllGroups();
    void saveGroup(Group group);
    Group getGroupById(Long id);
    void deleteGroup(Group group);
    void updateGroup(Group group,Long id);
}
