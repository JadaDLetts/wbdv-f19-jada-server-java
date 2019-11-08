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
import java.util.stream.Collectors;

import com.example.wbdvf19jadaserverjava.model.Widget;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class WidgetService {
    List<Widget> widgets = new ArrayList<Widget>();
    {
        widgets.add(new Widget(123, "Widget 1", "HEADING"));
        widgets.add(new Widget(234, "Widget 2", "PARAGRAPH"));
    }

    @PutMapping("/api/widgets/{widgetId}")
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
    } //////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return widgets;
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(
            @PathVariable("widgetId") int id) {
        for (Widget widget : widgets) {
            if (widget.getId() == id) {
                return widget;
            }
        }
        return null;
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public List<Widget> deleteWidget(@PathVariable("widgetId") int wid) {
        widgets = widgets
                .stream()
                .filter(widget -> !(widget.getId() == wid))
                .collect(Collectors.toList());
        return widgets;
    }
}