package com.example.wbdvf19jadaserverjava.model;


public class Widget {
    private int id;
    private String title;
    enum type {
        HEADING, LIST, PARAGRAPH, IMAGE, LINK;
    }
    private int order;
    private String text;
    private String url;
    private int width;
    private int height;
    private String style;
    private String value;
    enum dataType {
        INT, STRING, DATE, BOOL;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getStyle() {
        return this.style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Widget() {}

    public Widget(int id, String title, String type) {
        super();
        this.id = id;

    }
}