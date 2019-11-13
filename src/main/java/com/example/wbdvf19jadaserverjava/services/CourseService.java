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
        courses.add(new Course(123L, "CS 5610"));
        courses.add(new Course(234L,"CS 4500"));
        courses.add(new Course(345L, "CS 4550"));
        courses.add(new Course(456L,"CS 3600"));
        courses.add(new Course(567L, "CS 3650"));
    }

    @PutMapping("https://tranquil-refuge-56291.herokuapp.com/api/courses/{courseId}")
    public List<Course> updateCourse(
            @PathVariable("courseId") long id,
            @RequestBody Course newCourse) {
        for (Course course : courses) {
            if (course.getId() == id) {
                course.setTitle(newCourse.getTitle());
            }
        }
        return courses;
    }

    @PostMapping("https://tranquil-refuge-56291.herokuapp.com/api/courses")
    public List<Course> createCourse(
            @RequestBody Course course) {
        courses.add(course);
        return courses;
    }

    @GetMapping("https://tranquil-refuge-56291.herokuapp.com/api/courses")
    public List<Course> findAllCourses() {
        return courses;
    }

    @GetMapping("https://tranquil-refuge-56291.herokuapp.com/api/courses/{courseId}")
    public Course findCourseById(
            @PathVariable("courseId") long id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @DeleteMapping("https://tranquil-refuge-56291.herokuapp.com/api/courses/{courseId}")
    public List<Course> deleteCourse(@PathVariable("courseId") long cor) {
        courses = courses
                .stream()
                .filter(course -> !(course.getId() == cor))
                .collect(Collectors.toList());
        return courses;
    }
}