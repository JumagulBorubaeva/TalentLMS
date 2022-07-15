package com.peaksoft.dao.impl;

import com.peaksoft.dao.CourseDAO;
import com.peaksoft.dao.GroupDAO;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
@Transactional
public class GroupDaoImpl implements GroupDAO {
    @PersistenceContext
    EntityManager entityManager;
    private final CourseDAO courseDAO;

    @Autowired
    public GroupDaoImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Group> getAllGroups() {
        List<Group> groups =entityManager.createQuery("from Group",Group.class).getResultList();
        Comparator<Group> comparator=((o1, o2)->(int)(o1.getId()-o2.getId()));
        groups.sort(comparator);
        return groups;
    }

    @Override
    public void saveGroup(Group group,Long courseId) {
        Course course=courseDAO.getCourseById(courseId);
        List<Course>courses=new ArrayList<>();
        courses.add(course);
        List<Group>groups=new ArrayList<>();
        groups.add(group);
        course.setGroups(groups);
        group.setCourses(courses);
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
    @Override
    public List<Course> getCoursesByGroup(Long groupId) {
        List<Course>courses=entityManager.createQuery("select c from  Course c join c.groups g where g.id=?1",Course.class)
                .setParameter(1,groupId).getResultList();
        return courses;
    }
}
