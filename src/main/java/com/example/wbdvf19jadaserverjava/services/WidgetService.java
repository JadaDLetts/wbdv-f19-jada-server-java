//package com.example.wbdvf19jadaserverjava.services;
//
//import com.example.wbdvf19jadaserverjava.model.Widget;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@RestController
//public class WidgetService {
//    Widget wImage = new Widget(123, "Cat", 10, 10, "#");
//    Widget wLink = new Widget(234, "Google", 0, 0, "https://www.google.com/" );
//    Widget[] widgets = {wLink, wImage};
//
//    @GetMapping("/widgets")
//    public Widget[] findAllWidgets() {
//        return widgets;
//    }
//
//    @GetMapping("/widgets/{userId}")
//    public Widget findWidgetById(
//            @PathVariable("userId") Integer id) {
//                for (Widget widget : widgets) {
//                    if (widget.getId() == id) {
//                        return widget;
//                }
//            }
//        return null;
//    }
//}

package com.example.wbdvf19jadaserverjava.services;
import java.util.ArrayList;
import java.util.List;

import com.example.wbdvf19jadaserverjava.model.Widget;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WidgetService {
    List<Widget> widgets = new ArrayList<Widget>();
    {
        widgets.add(new Widget());
        widgets.add(new Widget());
    }

    @PutMapping("/api/widgets/{widgetId")
    public List<Widget> updateWidget(
            @PathVariable("widgetId") int id,
            @RequestBody Widget newWidget) {
        for (Widget widget: widgets) {
            if(widget.getId() == id) {
                widget.setTitle(newWidget.getTitle());
            }
        }
        return widgets;
    }

    @PostMapping("/api/widget")
    public List<Widget> createWidget(
            @RequestBody Widget widget) {
        widgets.add(widget);
        return widgets;
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllCourses() {
        return widgets;
    }

    @GetMapping("/api/courses/{userId}")
    public Widget findCourseById(
            @PathVariable("userId") Integer id) {
        for (Widget widget : widgets) {
            if (widget.getId() == id) {
                return widget;
            }
        }
        return null;
    }
}