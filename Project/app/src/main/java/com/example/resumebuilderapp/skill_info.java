package com.example.resumebuilderapp;

public class skill_info {
    private String skill1,skill2,skill3;
    public skill_info(){}

    public skill_info(String skill1, String skill2, String skill3) {
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
    }

    public String getSkill1() {
        return skill1;
    }

    public void setSkill1(String skill1) {
        this.skill1 = skill1;
    }

    public String getSkill2() {
        return skill2;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }

    public String getSkill3() {
        return skill3;
    }

    public void setSkill3(String skill3) {
        this.skill3 = skill3;
    }
}
