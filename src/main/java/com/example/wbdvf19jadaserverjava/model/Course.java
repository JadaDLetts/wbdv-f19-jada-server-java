package com.example.wbdvf19jadaserverjava.model;


public class Course {
	private String title;
    private long id;

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

    public Course() {}
    public Course(long id, String title) {
        super();
        this.id = id;
        this.title = title;
    }
}