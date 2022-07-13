package com.peaksoft.controller;

import com.peaksoft.entity.Course;
import com.peaksoft.entity.Group;
import com.peaksoft.service.CourseService;
import com.peaksoft.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;
    private final CourseService courseService;

    @Autowired
    public GroupController(GroupService groupService,CourseService courseService) {
        this.groupService = groupService;
        this.courseService=courseService;
    }
    @ModelAttribute("courseList")
    public List<Course> findAllCourses(){
        return courseService.getAllCourse();
    }

    @GetMapping
    public String getAllGroups(Model model){
        model.addAttribute("groups",groupService.getAllGroups());
        return "group/groups";

    }
    @GetMapping("/addGroup")
    public String addGroup(Model model){
        model.addAttribute("group",new Group());
        return "group/addGroup";
    }
    @PostMapping("/saveGroup")
    public String saveGroup(@ModelAttribute("group")Group group){
        groupService.saveGroup(group);
        return "redirect:/groups";
    }
    @GetMapping("/{id}/update")
    public String updateCompany(Model model, @PathVariable("id") long id){
        model.addAttribute("groupUpdate",groupService.getGroupById(id));
        return "group/updateGroup";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("groupUpdate") Group group,
                         @PathVariable("id") long id) {
        groupService.updateGroup(group,id);
        return "redirect:/groups";
    }
    @DeleteMapping("/{id}")
    public String deleteGroup(@PathVariable("id") Long id){
       Group group= groupService.getGroupById(id);
       groupService.deleteGroup(group);
       return "redirect:/groups";
    }
}
