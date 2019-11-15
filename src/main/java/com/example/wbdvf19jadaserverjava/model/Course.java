package com.example.wbdvf19jadaserverjava.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {
	private String title;
    private long id;
    private List<Widget> widgets;

    public Course(long id, String title) {
        super();
        this.id = id;
        this.title = title;
        this.widgets = new ArrayList<Widget>();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }


    public void setWidgetType(long widgetId, Type type) {
        for (Widget widget : this.widgets) {
            if (widget.getId() == widgetId) {
                widget.setType(type);
            }
        }
    }

    public void addWidget(Widget widget) {
        this.widgets.add(widget);
    }
    public void deleteWidget(Widget widget) {
        List<Widget> filtered = new ArrayList<>();
        for (Widget wid : this.widgets) {
            if (wid.getId() != widget.getId()) {
                filtered.add(wid);
            }
        }
        this.widgets = filtered;
    }

    public void createWidget() {
        this.widgets.add(new Widget((int)new Date().getTime(), "New Widget", Type.HEADING));
    }


}