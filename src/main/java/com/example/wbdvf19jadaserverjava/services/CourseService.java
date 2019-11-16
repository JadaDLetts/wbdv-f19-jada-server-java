package com.example.wbdvf19jadaserverjava.services;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.wbdvf19jadaserverjava.model.Course;
import com.example.wbdvf19jadaserverjava.model.Type;
import com.example.wbdvf19jadaserverjava.model.Widget;

public class CourseService {
    private List<Course> courses = new ArrayList<Course>();
    public CourseService() {
        Course cs5610 = new Course(123L, "CS 5610");
        Course cs4500 = new Course(234L,"CS 4500");
        Course cs4550 = new Course(345L, "CS 4550");
        Course cs3600 = new Course(456L,"CS 3600");
        Course cs3650 = new Course(567L, "CS 3650");

        courses.add(cs5610);

        cs5610.addWidget(new Widget(123L, "New Heading", Type.HEADING));
        cs5610.addWidget(new Widget(234L, "New List", Type.LIST));
        cs5610.addWidget(new Widget(345L, "New Paragraph", Type.PARAGRAPH));

        courses.add(cs4500);
        courses.add(cs4550);
        cs4550.addWidget(new Widget(456L, "New Hyperlink", Type.LINK));
        cs4550.addWidget(new Widget(567L, "New Image", Type.IMAGE));

        courses.add(cs3600);
        cs3600.addWidget(new Widget(678L, "New Heading", Type.HEADING));
        cs3600.addWidget(new Widget(789L, "New List", Type.LIST));
        cs3600.addWidget(new Widget(890L, "New Paragraph", Type.PARAGRAPH));
        courses.add(cs3650);
    }

    public List<Course> findAllCourses() {
        return this.courses;
    }

    public Course findCourseById(long courseId) {
        for (Course course : this.courses) {
            if (course.getId() == courseId) {
                return course;
            }
        }
        return null;
    }

    public void updateCourse(long courseId, Course course) {
        for (Course c : this.courses) {
            if (c.getId() == courseId) {
                this.deleteCourse(courseId);
                this.courses.add(course);
            }
        }
    }

    public void deleteCourse(long courseId) {
        List<Course> cList = new ArrayList<>();
        for(Course course : this.courses) {
            if (course.getId() != courseId) {
                cList.add(course);
            }
        }
        this.courses = cList;
    }


    void updateWidget(long courseId, long widgetId, Widget widget) {
        for (Widget w: this.findCourseById(courseId).getWidgets()) {
            if (w.getId() == widgetId) {
                this.findCourseById(courseId).deleteWidget(w);
                this.findCourseById(courseId).addWidget(widget);
            }
        }
    }

    List<Widget> findAllWidgets(long courseId) {

        return this.findCourseById(courseId).getWidgets();
    }

    Widget findWidgetById(long courseId, long wid) {
        for (Widget widg : this.findCourseById(courseId).getWidgets()) {
            if (widg.getId() == wid) {
                return widg;
            }
        }
        return null;
    }

    void setWidgetType(long courseId, long widgetId, Type type) {
        this.findCourseById(courseId).setWidgetType(widgetId, type);
    }

    void createWidget(long courseId) {
        this.findCourseById(courseId).createWidget();
    }

    void deleteWidget(long courseId, long widgetId) {
        for (Widget wid: this.findCourseById(courseId).getWidgets()) {
            if (wid.getId() == widgetId) {
                this.findCourseById(courseId).deleteWidget(wid);
            }
        }
    }

    public void createCourse(String title) {
        this.courses.add(new Course((int)new Date().getTime(), title));
    }
}