package com.peaksoft.controller;

import com.peaksoft.entity.Course;
import com.peaksoft.entity.Teacher;
import com.peaksoft.service.CourseService;
import com.peaksoft.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("teachers")
public class TeacherController {
    private final TeacherService teacherService;
    private final CourseService courseService;

    @Autowired
    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }
    @ModelAttribute("courseList")
    public List<Course> findAllCourse(){
        return courseService.getAllCourse();
    }

    @GetMapping()
    public String getAllTeacher(Model model){
        model.addAttribute("teachers",teacherService.getAllTeachers());
        return "teacher/teacher";
    }

    @GetMapping("/addTeacher")
    public String addTeacher(Model model){
        model.addAttribute("teacher",new Teacher());
        return "teacher/addTeacher";
    }

    @PostMapping("/saveTeacher")
    public String saveTeacher(@ModelAttribute("teacher")Teacher teacher){
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }
    @GetMapping("/{id}/update")
    public String updateCourse(Model model, @PathVariable("id")long id){
        model.addAttribute("updateTeacher",teacherService.getTeacherById(id));
        return "teacher/updateTeacher";
    }

    @PatchMapping ("/{id}")
    public String update(@ModelAttribute("updateTeacher")Teacher teacher,
                         @PathVariable("id")long id){
        teacherService.updateTeacher(teacher,id);
        return "redirect:/teachers";
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable("id")long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        teacherService.deleteTeacher(teacher);
        return "redirect:/teachers";
    }

}