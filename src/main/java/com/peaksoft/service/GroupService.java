package com.peaksoft.service;

import com.peaksoft.entity.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    void saveGroup(Group group);
    Group getGroupById(Long id);
    void deleteGroup(Group group);
    void updateGroup(Group group,Long id);
}
