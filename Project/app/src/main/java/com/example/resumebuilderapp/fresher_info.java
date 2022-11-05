package com.example.resumebuilderapp;

public class fresher_info {
    private String company,from,to,role;
    public fresher_info(){}

    public fresher_info(String company, String from, String to, String role) {
        this.company = company;
        this.from = from;
        this.to = to;
        this.role = role;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
