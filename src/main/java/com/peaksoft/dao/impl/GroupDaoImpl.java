package com.peaksoft.dao.impl;

import com.peaksoft.dao.GroupDAO;
import com.peaksoft.entity.Group;


import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDAO {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Group> getAllGroups() {
        List<Group> groups =entityManager.createQuery("from Group",Group.class).getResultList();
        Comparator<Group> comparator=((o1, o2)->(int)(o1.getId()-o2.getId()));
        groups.sort(comparator);
        return groups;
    }

    @Override
    public void saveGroup(Group group) {
     entityManager.persist(group);
    }

    @Override
    public Group getGroupById(Long id) {
        return entityManager.find(Group.class,id);
    }

    @Override
    public void deleteGroup(Group group) {
        entityManager.remove(entityManager.contains(group)?group:entityManager.merge(group));
    }

    @Override
    public void updateGroup(Group group,Long id) {
       Group group1=getGroupById(id);
       group1.setGroupName(group.getGroupName());
       group1.setDateOfCreate(group.getDateOfCreate());
       group1.setDateOfFinish(group.getDateOfFinish());
       entityManager.merge(group1);

    }
}
