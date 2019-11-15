package com.example.wbdvf19jadaserverjava.services;
import java.util.List;

import com.example.wbdvf19jadaserverjava.model.Widget;
import com.example.wbdvf19jadaserverjava.model.Type;

public class WidgetService {
    private CourseService courseService;

    public WidgetService() {
        this.courseService = new CourseService();
    }

    public void setWidgetType(long courseId, long widgetId, String s) {
        Type t = null;
        switch(s) {
            case "HEADING":
                t = Type.HEADING;
                break;
            case "LINK":
                t = Type.LINK;
                break;
            case "IMAGE":
                t = Type.IMAGE;
                break;
            case "LIST":
                t = Type.LIST;
                break;
            case "PARAGRAPH":
                t = Type.PARAGRAPH;
                break;
            default:
                break;
        }
        this.courseService.setWidgetType(courseId, widgetId, t);
    }

    public List<Widget> findAllWidgets(long courseId){
        return this.courseService.findAllWidgets(courseId);
    }

    public void createWidget(long courseId) {
        this.courseService.createWidget(courseId);
    }

    public void deleteWidget(long courseId, long widgetId) {
        this.courseService.deleteWidget(courseId, widgetId);
    }

    public Widget findWidgetById(long courseId, long widgetId) {
        List<Widget> widgets = this.courseService.findAllWidgets(courseId);
        for(Widget wid : widgets) {
            if( wid.getId() == widgetId) {
                return wid;
            }
        }
        return null;
    }

}