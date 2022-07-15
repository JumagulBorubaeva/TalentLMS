package com.peaksoft.service.impl;

import com.peaksoft.dao.StudentDAO;
import com.peaksoft.entity.Student;
import com.peaksoft.entity.StudyFormat;
import com.peaksoft.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public void saveStudent(Student student,Long id) {
        studentDAO.saveStudent(student,id);
    }


    @Override
    public Student getStudentById(Long id) {
        return studentDAO.getStudentById(id);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDAO.deleteStudent(student);
    }

    @Override
    public void updateStudent(Student student, Long id) {
        studentDAO.updateStudent(student, id);
    }

    @Override
    public void addStudent(Student student, StudyFormat studyFormat) {

    }
    @Override
    public List<Student> findByName(String name) {
        return studentDAO.findByName(name);
    }

}
