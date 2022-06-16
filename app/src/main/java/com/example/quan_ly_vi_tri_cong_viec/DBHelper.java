package com.example.quan_ly_vi_tri_cong_viec;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.quan_ly_vi_tri_cong_viec.models.NhanVien;
import com.example.quan_ly_vi_tri_cong_viec.models.ViTri;
import com.example.quan_ly_vi_tri_cong_viec.models.VitriCongViec;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "qlnhanvien.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table NhanVien(manv INTEGER PRIMARY KEY AUTOINCREMENT, tennv TEXT, namsinh TEXT, quequan TEXT, trinhdo TEXT)");
        DB.execSQL("create Table ViTri(mavt INTEGER PRIMARY KEY AUTOINCREMENT, tenvt TEXT, motavt TEXT)");
        DB.execSQL("create Table VitriCongViec(mavtcv INTEGER PRIMARY KEY AUTOINCREMENT, manv INTEGER, mavt INTEGER, thoigian TEXT, mota TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists NhanVien");
        DB.execSQL("drop Table if exists ViTri");
        DB.execSQL("drop Table if exists VitriCongViec");
        onCreate(DB);
    }

    // Nhan vien
    public Boolean insertnv (NhanVien nhanVien) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("tennv", nhanVien.getTennv());
        contentValues.put("namsinh", nhanVien.getNamsinh());
        contentValues.put("quequan", nhanVien.getQuequan());
        contentValues.put("trinhdo", nhanVien.getTrinhdo());

        long result = DB.insert("NhanVien", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getNhanVien() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM NhanVien", null);
        return cursor;
    }

    public Cursor findNv() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM NhanVien WHERE tennv LIKE '%Nam%' AND namsinh = 1995", null);
        return cursor;
    }

    // Vi trị
    public Boolean insertVitri (ViTri viTri) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("tenvt", viTri.getTenvt());
        contentValues.put("motavt", viTri.getMotavt());

        long result = DB.insert("ViTri", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getViTri() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM ViTri", null);
        return cursor;
    }

    // Vi tri cong viec
    public Boolean insertVitriCongviec (VitriCongViec vitriCongViec) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("manv", vitriCongViec.getManv());
        contentValues.put("mavt", vitriCongViec.getMavt());
        contentValues.put("thoigian", vitriCongViec.getThoigian());
        contentValues.put("mota", vitriCongViec.getMota());

        long result = DB.insert("VitriCongViec", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getViTriCongViec() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM VitriCongViec", null);
        return cursor;
    }
}
