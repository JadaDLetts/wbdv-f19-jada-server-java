package com.example.wbdvf19jadaserverjava.model;

import com.example.wbdvf19jadaserverjava.model.*;

public class Course {
	private String title;
    private int id;
    private int order;
    private String cssClass;
    private String style;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Course() {}
    public Course(int id, String title) {
        super();
        this.id = id;
        this.title = title;
    }
}