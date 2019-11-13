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
        widgets.add(new Widget(123L, "Widget 1", "HEADING"));
        widgets.add(new Widget(234L, "Widget 2", "PARAGRAPH"));
        widgets.add(new Widget(345L, "Widget 3", "LINK"));
        widgets.add(new Widget(456L, "Widget 4", "IMAGE"));
        widgets.add(new Widget(567L, "Widget 5", "LIST"));
    }

    @PutMapping("https://tranquil-refuge-56291.herokuapp.com/api/widgets/{widgetId}")
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

    @PostMapping("https://tranquil-refuge-56291.herokuapp.com/api/widgets")
    public List<Widget> createWidget(
            @RequestBody Widget widget) {
        widgets.add(widget);
        return widgets;
    }

    @GetMapping("https://tranquil-refuge-56291.herokuapp.com/api/widgets")
    public List<Widget> findAllWidgets() {
        return widgets;
    }

    @GetMapping("https://tranquil-refuge-56291.herokuapp.com/api/widgets/{widgetId}")
    public Widget findWidgetById(
            @PathVariable("widgetId") long id) {
        for (Widget widget : widgets) {
            if (widget.getId() == id) {
                return widget;
            }
        }
        return null;
    }

    @DeleteMapping("https://tranquil-refuge-56291.herokuapp.com/api/widgets/{widgetId}")
    public List<Widget> deleteWidget(@PathVariable("widgetId") long wid) {
        widgets = widgets
                .stream()
                .filter(widget -> !(widget.getId() == wid))
                .collect(Collectors.toList());
        return widgets;
    }
}