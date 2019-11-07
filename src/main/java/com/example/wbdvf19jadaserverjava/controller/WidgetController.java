package com.example.wbdvf19jadaserverjava.controller;

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
@CrossOrigin("*")
public class Widget {
    static List<Widget> widgets = new ArrayList<~>();
    static {
        widgets.add(new Widget(123, "Widget 1", "LIST"));
        widgets.add(new Widget(234, "Widget 2", "PARAGRAPH"));
        widgets.add(new Widget(345, "Widget 3", "IMAGE"));
        widgets.add(new Widget(456, "Widget 4", "LINK"));

    }

    @PostMapping("/api/widgets")
    public List<Widget> createWidget(@RequestBody Widget wid) {
        widgets.add(wid);
        return widgets;
    }

    @GetMapping("/api/widgetss")
    public List<Widget> findAllWidgets() {return widgets;}

    @GetMapping("/api/widgets/{widgetId")
    public Widget findWidgetById(@PathVariable("widgetId") int wid){
        for (Widget w: widgets) {
            if(w.getId().equals(wid))
                return w;
        }
        return null;
    }

    @PutMapping("/api/widgets/{widgetId")
    public Widget updateWidget(
            @PathVariable("widgetId)") int wid,
            @RequestBody Widget widget) {
        return widget;
    }

    @DeleteMapping("/api/widgets/{widgetId}")
    public List<Widget> deleteWidget(@PathVariable("widgetId") int wid) {
        widgets = widgets
                .stream()
                .filter(widget -> !widget.getId().equals(wid))
                .collect(Collectors.toList());
    }
}