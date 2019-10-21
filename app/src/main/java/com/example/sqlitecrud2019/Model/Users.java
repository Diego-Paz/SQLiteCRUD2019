package com.example.sqlitecrud2019.Model;

public class Users {
    private Integer id;
    private String Firstname;
    private String Lastname;
    private String Username;
    private String Password;
    private String Birth;
    private String Country;
    private String Phone;
    private String Gender;

    public Users(Integer id, String firstname, String lastname, String username, String password, String birth, String country, String phone, String gender) {
        this.id = id;
        Firstname = firstname;
        Lastname = lastname;
        Username = username;
        Password = password;
        Birth = birth;
        Country = country;
        Phone = phone;
        Gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
