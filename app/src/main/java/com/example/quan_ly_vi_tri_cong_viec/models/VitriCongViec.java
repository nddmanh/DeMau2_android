package com.example.quan_ly_vi_tri_cong_viec.models;

public class VitriCongViec {
    private int mavtcv, manv, mavt;
    private String thoigian, mota;

    public VitriCongViec(int manv, int mavt, String thoigian, String mota) {
        this.manv = manv;
        this.mavt = mavt;
        this.thoigian = thoigian;
        this.mota = mota;
    }

    public int getMavtcv() {
        return mavtcv;
    }

    public void setMavtcv(int mavtcv) {
        this.mavtcv = mavtcv;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public int getMavt() {
        return mavt;
    }

    public void setMavt(int mavt) {
        this.mavt = mavt;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
