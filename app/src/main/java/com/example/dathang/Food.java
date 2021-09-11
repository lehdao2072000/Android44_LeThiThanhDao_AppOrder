package com.example.dathang;

public class Food {
    String tenMon;
    double donGia;
    int soLuong;

    public Food(String tenMon, double donGia, int soLuong) {
        this.tenMon = tenMon;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
