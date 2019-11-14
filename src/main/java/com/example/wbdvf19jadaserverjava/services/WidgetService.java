package com.example.wbdvf19jadaserverjava.services;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.wbdvf19jadaserverjava.model.Type;
import com.example.wbdvf19jadaserverjava.model.Widget;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:3000",allowCredentials="true",allowedHeaders="*")
public class WidgetService {
    List<Widget> widgets = new ArrayList<Widget>();
    {
        widgets.add(new Widget(123L, "Widget 1", "HEADING"));
        widgets.add(new Widget(234L, "Widget 2", "PARAGRAPH"));
        widgets.add(new Widget(345L, "Widget 3", "LINK"));
        widgets.add(new Widget(456L, "Widget 4", "IMAGE"));
        widgets.add(new Widget(567L, "Widget 5", "LIST"));
    }

    @PutMapping("/api/widgets/{widgetId}")
    public List<Widget> updateWidget(
            @PathVariable("widgetId") long id,
            @RequestBody Widget newWidget) {
        for (Widget widget: widgets) {
            if(widget.getId() == id) {
                widget.setTitle(newWidget.getTitle());
            }
        }
        return widgets;
    }

    @PostMapping("/api/widgets")
    public List<Widget> createWidget(
            @RequestBody Widget widget) {
        widgets.add(widget);
        return widgets;
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return widgets;
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(
            @PathVariable("widgetId") long id) {
        for (Widget widget : widgets) {
            if (widget.getId() == id) {
                return widget;
            }
        }
        return null;
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public List<Widget> deleteWidget(@PathVariable("widgetId") long wid) {
        widgets = widgets
                .stream()
                .filter(widget -> !(widget.getId() == wid))
                .collect(Collectors.toList());
        return widgets;
    }

    @PutMapping("/api/courses/{cid}/widgets/{wid}")
    public List<Widget> setWidgetType
            (@PathVariable("cid") int cid,
             @PathVariable("wid") int wid,
             @RequestBody String type) {
        Type t;
        switch(type) {
            case "HEADING":
                t = Type.HEADING;
                break;
            case "PARAGRAPH":
                t = Type.PARAGRAPH;
                break;
            case "LIST":
                t = Type.LIST;
                break;
            case "LINK":
                t = Type.LINK;
                break;
            case "IMAGE":
                t = Type.IMAGE;
                break;
            default:
                throw new IllegalArgumentException("invalid type");
        }
        return widgets;
    }
}