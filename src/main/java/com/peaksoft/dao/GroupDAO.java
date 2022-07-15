package com.peaksoft.dao;

import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;

import java.util.List;

public interface GroupDAO {
    List<Group>getAllGroups();
    void saveGroup(Group group,Long courseId);
    Group getGroupById(Long id);
    void deleteGroup(Group group);
    void updateGroup(Group group,Long id);

    List<Course> getCoursesByGroup(Long groupId);
}
