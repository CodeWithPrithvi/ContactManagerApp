package com.prithviraj.contatcsstoringapp;

public class contact {


    private int uId;

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    private String uName;
    private String uNumber;
    private String uEmail;

    public contact() {
    }

    public contact(int uId, String uName, String uNumber, String uEmail) {
        this.uId = uId;
        this.uName = uName;
        this.uNumber = uNumber;
        this.uEmail = uEmail;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuNumber() {
        return uNumber;
    }

    public void setuNumber(String uNumber) {
        this.uNumber = uNumber;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }
}
