package com.example.lab3;

public class CauThu {
    private String avatar;
    private String name;
    private String descript;
    private String  country;

    public CauThu(String avatar, String name, String descript, String country) {
        this.avatar = avatar;
        this.name = name;
        this.descript = descript;
        this.country = country;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
