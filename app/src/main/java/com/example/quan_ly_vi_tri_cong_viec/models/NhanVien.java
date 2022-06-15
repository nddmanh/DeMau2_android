package com.example.quan_ly_vi_tri_cong_viec.models;

public class NhanVien {
    private int manv;
    private String tennv, namsinh, quequan, trinhdo;

    public NhanVien(String tennv, String namsinh, String quequan, String trinhdo) {
        this.tennv = tennv;
        this.namsinh = namsinh;
        this.quequan = quequan;
        this.trinhdo = trinhdo;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(String namsinh) {
        this.namsinh = namsinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getTrinhdo() {
        return trinhdo;
    }

    public void setTrinhdo(String trinhdo) {
        this.trinhdo = trinhdo;
    }
}
