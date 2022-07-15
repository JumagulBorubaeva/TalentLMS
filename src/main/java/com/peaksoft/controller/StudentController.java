package com.peaksoft.controller;

import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.entity.Student;
import com.peaksoft.service.GroupService;
import com.peaksoft.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private  final StudentService studentService;
    private final GroupService groupService;

    public StudentController(StudentService studentService,GroupService groupService ) {
        this.studentService = studentService;
        this.groupService=groupService;
    }
    @ModelAttribute("groupList")
    public List<Group> findAllGroup(){
        return groupService.getAllGroups();
    }
    @GetMapping
    public String getAllStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "student/student";

    }
    @GetMapping("/addStudent")
    public  String addStudent(Model model){
        model.addAttribute("student",new Student());
    return "student/addStudent";
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student){
        studentService.saveStudent(student,student.getGroupId());
        return "redirect:/students";
    }


    @GetMapping("/{id}/studentUpdate")
    public String updateStudent(@PathVariable("id") Long id, Model model){
        Student student =  studentService.getStudentById(id);
        model.addAttribute("updateStudent", student);
        return "student/updateStudent";
    }

    @PatchMapping ("/{id}")
    public String saveUpdateStudent(@PathVariable("id") Long id,@ModelAttribute("student") Student student){
        studentService.updateStudent(student,id);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String deleteStudents(@PathVariable("id")Long id){
        studentService.deleteStudent(studentService.getStudentById(id));
        return "redirect:/students";
    }
}
