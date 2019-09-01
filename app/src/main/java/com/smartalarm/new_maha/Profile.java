package com.smartalarm.new_maha;

/**
 * Created by MAHA on 1/18/2019.
 */

public class Profile {
    public String age;
    public String userName;
    public String userEmail;
    public String height;
    public String weidth;
    public String gender;
    public String inch;
    public Profile(){

    }


    public Profile(String age1, String userName1, String userEmail1,String height2,String weidth2,String srtGender,String inch2)
    {
        this.age=age1;
        this.userName=userName1;
        this.userEmail=userEmail1;
        this.height=height2;
        this.weidth=weidth2;
        this.gender=srtGender;
        this.inch=inch2;

    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeidth() {
        return weidth;
    }

    public void setWeidth(String weidth) {
        this.weidth = weidth;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInch() {
        return inch;
    }

    public void setInch(String inch) {
        this.inch = inch;
    }


}


