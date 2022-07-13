package com.peaksoft.dao;



import com.peaksoft.entity.Teacher;

import java.util.List;

public interface TeacherDAO {
    List<Teacher> getAllTeachers();
    void saveTeacher(Teacher teacher);
    Teacher getTeacherById(Long id);
    void deleteTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher,Long id);
}
