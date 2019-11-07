package com.example.wbdvf19jadaserverjava.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.wbdvf19jadaserverjava.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CourseController {
    static List<Course> courses = new ArrayList<~>();
    static {
        courses.add(new Course(123, "CS 4500"));
        courses.add(new Course(234, "CS 4550"));
        courses.add(new Course(345, "CS 3650"));
    }

    @PostMapping("/api/courses")
    public List<Course> createCourse(@RequestBody Course cours) {
        courses.add(course);
        return courses;
    }

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {return courses;}

    @GetMapping("/api/widgets/{courseId")
    public Course findCourseById(@PathVariable("courseId") int cor){
        for (Course c: courses) {
            if(c.getId().equals(cor))
                return c;
        }
        return null;
    }

    @PutMapping("/api/courses/{courseId")
    public Course updateCourse(
            @PathVariable("courseId)") int cor,
            @RequestBody Course course) {
        return course;
    }

    @DeleteMapping("/api/courses/{courseId}")
    public List<Course> deleteCourse(@PathVariable("courseId") int cor) {
        courses = courses
                .stream()
                .filter(course -> !course.getId().equals(cor))
                .collect(Collectors.toList());
    }
}