package com.springrest.springrest.controller;


import com.springrest.springrest.entity.Course;
import com.springrest.springrest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home(){
        return "This is home page";
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses(){

        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable String courseId){
        return courseService.getCourseById(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Course addCourses(@RequestBody Course course){

        return courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public String deleteMapping(@PathVariable String courseId){
        courseService.deleteCourse(Long.parseLong(courseId));
        return "Deleted";
    }

}
