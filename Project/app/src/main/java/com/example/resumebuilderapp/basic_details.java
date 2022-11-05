package com.example.resumebuilderapp;

public class basic_details {

    private String name;
    private String add1;
    private String add2;
    private String add3;
    private String email;
    private String mobno;

    public  basic_details()
    {}

    public  basic_details( String name, String add1, String add2, String add3, String email, String mobno) {

        this.name = name;
        this.add1 = add1;
        this.add2 = add2;
        this.add3 = add3;
        this.email = email;
        this.mobno = mobno;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public String getAdd3() {
        return add3;
    }

    public void setAdd3(String add3) {
        this.add3 = add3;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobno() {
        return mobno;
    }

    public void setMobno(String mobno) {
        this.mobno = mobno;
    }
}

