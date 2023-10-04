package com.example.lab3;

import android.graphics.Bitmap;

public class TraiCay {
    private String Ten, Mota;
    private Bitmap Hinh;


    public TraiCay(String ten, String mota, Bitmap hinh) {
        this.Ten = ten;
        this.Mota = mota;
        this.Hinh = hinh;
    }

    public String getTen() {
        return this.Ten;
    }

    public void setTen(String ten) {
        this.Ten = ten;
    }

    public String getMota() {
        return this.Mota;
    }

    public void setMota(String mota) {
        this.Mota = mota;
    }

    public Bitmap getHinh() {
        return this.Hinh;
    }

    public void setHinh(Bitmap hinh) {
        this.Hinh = hinh;
    }
}
