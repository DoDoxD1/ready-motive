package com.example.readymotive;

public class User {
    private String lname, fname, email, password, mobileNumber;

    public User() {
    }

    public User(String lname, String fname, String email, String password, String mobileNumber) {
        this.lname = lname;
        this.fname = fname;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
