package com.example.wbdvf19jadaserverjava.services;

import com.example.wbdvf19jadaserverjava.model.Widget;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class WidgetService {
    Widget wImage = new Widget(123, "Cat", 10, 10, "#");
    Widget wLink = new Widget(234, "Google", 0, 0, "https://www.google.com/" );
    Widget[] widgets = {wLink, wImage};

    @GetMapping("/widgets")
    public Widget[] findAllWidgets() {
        return widgets;
    }

    @GetMapping("/widgets/{userId}")
    public Widget findWidgetById(
            @PathVariable("userId") Integer id) {
                for (Widget widget : widgets) {
                    if (widget.getId() == id) {
                        return widget;
                }
            }
        return null;
    }
}