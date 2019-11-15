package com.example.wbdvf19jadaserverjava.controller;

import com.example.wbdvf19jadaserverjava.model.Course;
import com.example.wbdvf19jadaserverjava.services.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins="*",allowCredentials="true",allowedHeaders="*")
public class CourseController {
    private CourseService courseService = new CourseService();

    @PutMapping("/api/courses/{courseId}")
    public List<Course> updateCourse(
            @PathVariable("courseId") long courseId,
            @RequestBody Course newCourse) {
        courseService.updateCourse(courseId, newCourse);
        return courseService.findAllCourses();
    }

    @PostMapping("/api/courses")
    public List<Course> createCourse(
            @RequestBody String title) {
        courseService.createCourse(title);
        return courseService.findAllCourses();
    }

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/api/courses/{courseId}")
    public Course findCourseById(
            @PathVariable("courseId") long courseId) {
        return courseService.findCourseById(courseId);
    }

    @DeleteMapping("/api/courses/{courseId}")
    public List<Course> deleteCourse(
            @PathVariable("courseId") long courseId) {
        courseService.deleteCourse(courseId);
        return courseService.findAllCourses();
    }
}