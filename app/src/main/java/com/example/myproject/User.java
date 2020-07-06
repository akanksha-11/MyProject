package com.example.myproject;

public class User {

    private String Name;
    private String Gender;
    private long Age;
    private String Remarks;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public long getAge() {
        return Age;
    }

    public void setAge(long age) {
        Age = age;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String remarks) {
        Remarks = remarks;
    }

    public User() {

    }

}
