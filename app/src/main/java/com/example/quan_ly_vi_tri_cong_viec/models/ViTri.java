package com.example.quan_ly_vi_tri_cong_viec.models;

public class ViTri {
    private int mavt;
    private String tenvt, motavt;

    public ViTri(String tenvt, String motavt) {
        this.tenvt = tenvt;
        this.motavt = motavt;
    }

    public int getMavt() {
        return mavt;
    }

    public void setMavt(int mavt) {
        this.mavt = mavt;
    }

    public String getTenvt() {
        return tenvt;
    }

    public void setTenvt(String tenvt) {
        this.tenvt = tenvt;
    }

    public String getMotavt() {
        return motavt;
    }

    public void setMotavt(String motavt) {
        this.motavt = motavt;
    }
}
