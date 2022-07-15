package com.peaksoft.service;

import com.peaksoft.entity.Student;
import com.peaksoft.entity.StudyFormat;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void saveStudent(Student student,Long id);
    Student getStudentById(Long id);
    void deleteStudent(Student student);

    void updateStudent(Student student,Long id);

    void addStudent(Student student, StudyFormat studyFormat);
    List<Student>findByName(String name);

}
