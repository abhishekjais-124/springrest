package com.springrest.springrest.service;

import com.springrest.springrest.entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    List<Course> list;

    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(1L,"Python", "Python oops"));
        list.add(new Course(2L,"Java", "Java core book"));
    }

    @Override
    public List<Course> getAllCourses() {
        return list;
    }

    @Override
    public Course getCourseById(Long courseId) {
        Course c = null;
        for(Course course: list){
            if (course.getId() == courseId){
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        for(Course c: list){
            if (course.getId() == c.getId()){
                c.setTitle(course.getTitle());
                c.setDescription(course.getDescription());
                break;
            }
        }
        return course;
    }

    @Override
    public void deleteCourse(Long courseId) {
        for(Course course: list){
            if (course.getId() == courseId){
                list.remove(course);
                break;
            }
        }
    }
}
