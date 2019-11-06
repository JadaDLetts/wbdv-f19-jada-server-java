package com.example.whiteboard.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whiteboard.model.Course;

@RestController
public class CourseService {
    Course cs5610 = new Course(123, "CS5610");
    Course cs4500 = new Course(234, "CS4500");
    List<Course> courses = new ArrayList<Course>();
    {
        courses.add(cs4500);
        courses.add(cs5610);
    }

    @PutMapping("/api/courses/{courseId")
    public Course updateCourse(
            @PathVariable("courseId") int id,
            @RequestBody Course newCourse) {
        for (Course course:courses) {
            if(course.getId() == id) {
                course.setTitle(newCourse.getTitle());
                return course;
            }
        }
        return null;
    }

    @PostMapping("/api/course")
    public Course createCourse(
            @RequestBody Course course) {
        courses.add(course);
        return course;
    }

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return courses;
    }

    @GetMapping("/api/courses/{userId}")
    public Course findCourseById(
            @PathVariable("userId") Integer id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }
}