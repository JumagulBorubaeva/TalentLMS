package com.peaksoft.dao;

import com.peaksoft.entity.Course;

import java.util.List;

public interface CourseDAO {
    List<Course>getAllCourse();
    void addCourse(Course course,Long companyId);
    Course getCourseById(Long id);
    void updateCourse(Course course,Long id);
    void deleteCourse(Course course);
}
