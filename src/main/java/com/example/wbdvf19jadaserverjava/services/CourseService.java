package com.example.wbdvf19jadaserverjava.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.wbdvf19jadaserverjava.model.Course;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class CourseService {
    List<Course> courses = new ArrayList<Course>();

    {
        courses.add(new Course(123, "CS 5610", 1));
        courses.add(new Course(234,"CS 4500", 2));
        courses.add(new Course(345, "CS 4550", 3));
        courses.add(new Course(456,"CS 3600", 4));
    }

    @PutMapping("/api/courses/{courseId}")
    public List<Course> updateCourse(
            @PathVariable("courseId") int id,
            @RequestBody Course newCourse) {
        for (Course course : courses) {
            if (course.getId() == id) {
                course.setTitle(newCourse.getTitle());
            }
        }
        return courses;
    }

    @PostMapping("/api/course")
    public List<Course> createCourse(
            @RequestBody Course course) {
        courses.add(course);
        return courses;
    }

    @GetMapping("/api/courses")
    public List<Course> findAllCourses() {
        return courses;
    }

    @GetMapping("/api/courses/{courseId}")
    public Course findCourseById(
            @PathVariable("courseId") int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @DeleteMapping("/api/courses/{courseId}")
    public List<Course> deleteCourse(@PathVariable("courseId") int cor) {
        courses = courses
                .stream()
                .filter(course -> !(course.getId() == cor))
                .collect(Collectors.toList());
        return courses;
    }
}