package com.peaksoft.service.impl;

import com.peaksoft.dao.TeacherDAO;
import com.peaksoft.entity.Teacher;
import com.peaksoft.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherDAO teacherDAO;

    @Autowired
    public TeacherServiceImpl(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherDAO.saveTeacher(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherDAO.getTeacherById(id);
    }

    @Override
    public void deleteTeacher(Teacher teacher) {
        teacherDAO.deleteTeacher(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher,Long id) {
        teacherDAO.updateTeacher(teacher,id);
    }
}
