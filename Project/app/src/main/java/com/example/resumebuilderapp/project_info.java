package com.example.resumebuilderapp;

public class project_info {
    private String title1, description1, title2, description2;
    private String Duration1, Duration2;


    public project_info() {}

    public project_info(String title1, String description1, String title2, String description2, String duration1, String duration2) {
        this.title1 = title1;
        this.description1 = description1;
        this.title2 = title2;
        this.description2 = description2;
        Duration1 = duration1;
        Duration2 = duration2;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getDuration1() {
        return Duration1;
    }

    public void setDuration1(String duration1) {
        Duration1 = duration1;
    }

    public String getDuration2() {
        return Duration2;
    }

    public void setDuration2(String duration2) {
        Duration2 = duration2;
    }
}
