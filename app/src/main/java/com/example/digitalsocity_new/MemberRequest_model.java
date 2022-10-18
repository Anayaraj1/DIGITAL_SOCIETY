package com.example.digitalsocity_new;

public class MemberRequest_model
{
    String id;
    String name;
    String email;
    String password;
    String house_no;
    String contact_n0;
    String status;

    public MemberRequest_model(String id, String name, String email, String password, String house_no, String contact_n0, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.house_no = house_no;
        this.contact_n0 = contact_n0;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHouse_no() {
        return house_no;
    }

    public void setHouse_no(String house_no) {
        this.house_no = house_no;
    }

    public String getContact_n0() {
        return contact_n0;
    }

    public void setContact_n0(String contact_n0) {
        this.contact_n0 = contact_n0;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
