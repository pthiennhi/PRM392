package com.example.lab3_2_phamthiennhi_se150257;

public class TraiCay {
    private String Ten, Mota;
    private int Hinh;


    public TraiCay(String ten, String mota, int hinh) {
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

    public int getHinh() {
        return this.Hinh;
    }

    public void setHinh(int hinh) {
        this.Hinh = hinh;
    }
}
