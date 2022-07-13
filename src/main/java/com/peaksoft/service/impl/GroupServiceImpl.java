package com.peaksoft.service.impl;

import com.peaksoft.dao.GroupDAO;
import com.peaksoft.entity.Group;
import com.peaksoft.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private final GroupDAO groupDAO;

    @Autowired
    public GroupServiceImpl(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDAO.getAllGroups();
    }

    @Override
    public void saveGroup(Group group) {
        groupDAO.saveGroup(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return groupDAO.getGroupById(id);
    }

    @Override
    public void deleteGroup(Group group) {
        groupDAO.deleteGroup(group);
    }

    @Override
    public void updateGroup(Group group,Long id) {
        groupDAO.updateGroup(group,id);
    }
}
