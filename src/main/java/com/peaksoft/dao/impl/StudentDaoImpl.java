package com.peaksoft.dao.impl;

import com.peaksoft.dao.CourseDAO;
import com.peaksoft.dao.GroupDAO;
import com.peaksoft.dao.StudentDAO;
import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;
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
public class StudentDaoImpl implements StudentDAO {
    @PersistenceContext
    EntityManager entityManager;
    private  final GroupDAO groupDAO;
    private final CourseDAO courseDAO;



    @Autowired
    public StudentDaoImpl(GroupDAO groupDAO,CourseDAO courseDAO) {
        this.groupDAO = groupDAO;
        this.courseDAO=courseDAO;

    }


    @Override
    public List<Student> getAllStudents() {
        List<Student> students = entityManager.createQuery("from Student", Student.class).getResultList();
        Comparator<Student> comparator = ((o1, o2) -> (int) (o1.getId() - o2.getId()));
        students.sort(comparator);
        return students;
    }



    @Override
    public void saveStudent(Student student,Long id) {
        Group group =groupDAO.getGroupById(id);
        List<Student>students=new ArrayList<>();
        students.add(student);
        student.setGroup(group);
        group.setStudents(students);
        entityManager.persist(student);

    }


    @Override
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void deleteStudent(Student student) {
        entityManager.remove(entityManager.contains(student) ? student : entityManager.merge(student));
    }


    @Override
    public void updateStudent(Student student, Long id) {
        Student existedStudent = entityManager.find(Student.class,id);
        existedStudent.setEmail(student.getEmail());
        existedStudent.setFirstName(student.getFirstName());
        existedStudent.setLastName(student.getLastName());
        existedStudent.setStudyFormat(student.getStudyFormat());
        entityManager.persist(existedStudent);


    }
    @Override
    public List<Student>findByName(String name){
        List<Student>students=
                entityManager.createQuery("select s from Student s where s.firstName=?1",
                        Student.class).setParameter(1,name).getResultList();
        return students;

    }
}