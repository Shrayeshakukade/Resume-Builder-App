package com.example.resumebuilderapp;

public class education_info {
    private  String course,institute,cgpa,yop,scname,hscname,scmks,hscmks;
   public education_info(){}

    public education_info(String course, String institute, String cgpa, String yop, String scname, String hscname, String scmks, String hscmks) {
        this.course = course;
        this.institute = institute;
        this.cgpa = cgpa;
        this.yop = yop;
        this.scname = scname;
        this.hscname = hscname;
        this.scmks = scmks;
        this.hscmks = hscmks;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getYop() {
        return yop;
    }

    public void setYop(String yop) {
        this.yop = yop;
    }

    public String getScname() {
        return scname;
    }

    public void setScname(String scname) {
        this.scname = scname;
    }

    public String getHscname() {
        return hscname;
    }

    public void setHscname(String hscname) {
        this.hscname = hscname;
    }

    public String getScmks() {
        return scmks;
    }

    public void setScmks(String scmks) {
        this.scmks = scmks;
    }

    public String getHscmks() {
        return hscmks;
    }

    public void setHscmks(String hscmks) {
        this.hscmks = hscmks;
    }
}
