package com.example.resumebuilderapp;

public class personal_info {
    private String dob;

    private String lang;
    private String nation;

    public personal_info() {
    }

    public personal_info(String dob, String lang, String nation) {
        this.dob = dob;
        this.lang = lang;
        this.nation = nation;

    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }



}