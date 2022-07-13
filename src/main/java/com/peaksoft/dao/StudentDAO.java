package com.peaksoft.dao;


import com.peaksoft.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents();
    void saveStudent(Student student);
    Student getStudentById(Long id);
    void deleteStudent(Student student);
    void updateStudent(Student student,Long id);


}
