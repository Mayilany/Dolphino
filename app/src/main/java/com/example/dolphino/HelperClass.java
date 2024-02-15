package com.example.dolphino;

public class HelperClass {
    public HelperClass() {
    }

    String name,Email,phone,password,CPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCPassword() {
        return CPassword;
    }

    public void setCPassword(String CPassword) {
        this.CPassword = CPassword;
    }

    public HelperClass(String name, String email, String phone, String password, String CPassword) {
        this.name = name;
        Email = email;
        this.phone = phone;
        this.password = password;
        this.CPassword = CPassword;
    }
}
