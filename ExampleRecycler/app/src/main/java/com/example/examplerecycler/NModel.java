package com.example.examplerecycler;

public class NModel {

    String title,link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public NModel(String title, String link) {
        this.title = title;
        this.link = link;
    }
}
