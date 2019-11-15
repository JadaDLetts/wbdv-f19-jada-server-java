package com.example.wbdvf19jadaserverjava.controller;

import com.example.wbdvf19jadaserverjava.model.Widget;
import com.example.wbdvf19jadaserverjava.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="*",allowCredentials="true",allowedHeaders="*")
public class WidgetController {

    WidgetService widgetService = new WidgetService();

//    List<Widget> widgets = new ArrayList<Widget>();
//    {
//        widgets.add(new Widget(123L, "Widget 1", "HEADING"));
//        widgets.add(new Widget(234L, "Widget 2", "PARAGRAPH"));
//        widgets.add(new Widget(345L, "Widget 3", "LINK"));
//        widgets.add(new Widget(456L, "Widget 4", "IMAGE"));
//        widgets.add(new Widget(567L, "Widget 5", "LIST"));
//    }

    @PostMapping("/api/courses/{courseId}/widgets")
    public List<Widget> createWidget(
            @PathVariable("courseId") long courseId) {
        widgetService.createWidget(courseId);
        return widgetService.findAllWidgets(courseId);
    }

    @GetMapping("/api/courses/{courseId}/widgets")
    public List<Widget> findAllWidgets(
            @PathVariable("courseId") long courseId){
               return widgetService.findAllWidgets(courseId);
    }

    @GetMapping("/api/courses/{courseId}/widgets/{widgetId}")
    public Widget findWidgetById(
            @PathVariable("widgetId") long widgetId,
            @PathVariable("courseId") long courseId) {
        return widgetService.findWidgetById(courseId, widgetId);
    }

    @DeleteMapping("/api/courses/{courseId}/widgets/{widgetId}")
    public List<Widget> deleteWidget(
            @PathVariable("widgetId") long widgetId,
            @PathVariable("courseId") long courseId,
            @RequestBody String type) {
        widgetService.setWidgetType(courseId, widgetId, type);
        return widgetService.findAllWidgets(courseId);
    }
}