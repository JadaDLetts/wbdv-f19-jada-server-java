package com.example.wbdvf19jadaserverjava.model;


public class Widget {
    private long id;
    private String title;
    private Type type;
    private int size;
    private String text;
    private String url;
    private boolean isOrdered;

    public Widget(long id, String title, Type type) {
        super();
        this.id = id;
        this.title = title;
        this.type = type;
        this.size = 1;
        this.isOrdered = false;
        this.url = "";


        switch (type) {
            case HEADING:
                this.text = "Heading 1";
                break;
            case LINK:
                this.text = "Go To Reddit";
                this.url = "https://www.reddit.com";
                break;
            case PARAGRAPH:
                this.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus egestas volutpat leo, " +
                        "eget venenatis mi efficitur id.";
                break;
            case IMAGE:
                this.text = "";
                this.url = "https://live.staticflickr.com/65535/48883505998_cd7d028f9b_o.png";
                break;
            case LIST:
                this.text = "Item1\nItem2\nItem 3";
                break;
            default:
                break;
        }
    }

    public long getId(){return this.id;}
    public void setId(long id){this.id = id;}

    public String getText(){return this.text;}
    public void setText(String text){this.text = text;}

    public String getUrl(){return this.url;}
    public void setUrl(String url){this.url = url;}

    public Type getType(){return type;}
    public void setType(Type type){
        this.type = type;
        this.size = 1;
        this.isOrdered = false;
        this.url = "";


        switch (type) {
            case HEADING:
                this.text = "Heading 1";
                break;
            case LINK:
                this.text = "Go To Reddit";
                this.url = "https://www.reddit.com";
                break;
            case PARAGRAPH:
                this.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus egestas volutpat leo, " +
                        "eget venenatis mi efficitur id.";
                break;
            case IMAGE:
                this.text = "";
                this.url = "https://live.staticflickr.com/65535/48883505998_cd7d028f9b_o.png";
                break;
            case LIST:
                this.text = "Item1\nItem2\nItem 3";
                break;
            default:
                break;
        }
    }

    public int getSize(){return this.size;}
    public void setSize(int size){this.size = size;}

    public boolean ordered(){return this.isOrdered;}

    public String getTitle(){return this.title;}
    public void setTitle(String title){this.title = title;}

    public void changeOrdered() {this.isOrdered = !this.isOrdered;}
}