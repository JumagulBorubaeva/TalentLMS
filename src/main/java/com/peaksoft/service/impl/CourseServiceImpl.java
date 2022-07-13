package com.peaksoft.service.impl;

import com.peaksoft.dao.CourseDAO;
import com.peaksoft.entity.Course;
import com.peaksoft.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseDAO courseDAO;

    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDAO.getAllCourse();
    }

    @Override
    public void addCourse(Course course,Long companyId) {
        courseDAO.addCourse(course,companyId);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseDAO.getCourseById(id);
    }

    @Override
    public void updateCourse(Course course,Long id) {
        courseDAO.updateCourse(course, id);
    }

    @Override
    public void deleteCourse(Course course) {
        courseDAO.deleteCourse(course);
    }
}
