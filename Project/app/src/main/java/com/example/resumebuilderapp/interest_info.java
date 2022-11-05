package com.example.resumebuilderapp;

public class interest_info {
    private  String interest1,interest2,interest3;
    public interest_info(){}

    public interest_info(String interest1, String interest2, String interest3) {
        this.interest1 = interest1;
        this.interest2 = interest2;
        this.interest3 = interest3;
    }

    public String getInterest1() {
        return interest1;
    }

    public String getInterest2() {
        return interest2;
    }

    public String getInterest3() {
        return interest3;
    }

    public void setInterest1(String interest1) {
        this.interest1 = interest1;
    }

    public void setInterest2(String interest2) {
        this.interest2 = interest2;
    }

    public void setInterest3(String interes3) {
        this.interest3 = interes3;
    }
}
