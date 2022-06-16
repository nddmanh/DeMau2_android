package com.example.quan_ly_vi_tri_cong_viec;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quan_ly_vi_tri_cong_viec.models.VitriCongViec;

import java.util.ArrayList;
import java.util.List;

public class VitriCongViecActivity extends AppCompatActivity {
    DBHelper DB;
    Button btn_addnvvt, btn_viewnvvt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitri_cong_viec);

        DB = new DBHelper(this);

        Spinner ma_nv = findViewById(R.id.ma_nv);
        Spinner ma_vitri = findViewById(R.id.ma_vitri);
        EditText thoi_gian = findViewById(R.id.thoi_gian);
        EditText mota_vtcv = findViewById(R.id.mota_vtcv);

        List<String> drowdownNv = new ArrayList<>();
        List<String> drowdownVt = new ArrayList<>();

        Cursor listNv = DB.getNhanVien();
        Cursor listVt = DB.getViTri();
        if (listNv.getCount() == 0) {
            Toast.makeText(VitriCongViecActivity.this, "Khong tim thay nhan vien", Toast.LENGTH_SHORT).show();
            return;
        }
        while(listNv.moveToNext()) {
            drowdownNv.add(listNv.getString(0));
        }

        if (listVt.getCount() == 0) {
            Toast.makeText(VitriCongViecActivity.this, "Khong tim thay vi tri", Toast.LENGTH_SHORT).show();
            return;
        }
        while(listVt.moveToNext()) {
            drowdownVt.add(listVt.getString(0));
        }

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, drowdownNv);
        ma_nv.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, drowdownVt);
        ma_vitri.setAdapter(adapter2);

        btn_addnvvt = findViewById(R.id.btn_addnvvt);
        btn_viewnvvt = findViewById(R.id.btn_viewnvvt);

        btn_addnvvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer manv = Integer.parseInt(ma_nv.getSelectedItem().toString());
                Integer mavitri = Integer.parseInt(ma_vitri.getSelectedItem().toString());
                String tgian = thoi_gian.getText().toString();
                String note = mota_vtcv.getText().toString();

                VitriCongViec vitriCongViec = new VitriCongViec(manv, mavitri, tgian, note);
                Boolean checkinsert = DB.insertVitriCongviec(vitriCongViec);
                if (checkinsert == true) {
                    Toast.makeText(VitriCongViecActivity.this, "Add oke", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(VitriCongViecActivity.this, "Add fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_viewnvvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor listVtcv = DB.getViTriCongViec();
                if (listVtcv.getCount() == 0) {
                    Toast.makeText(VitriCongViecActivity.this, "Khong tim thay nhan vien", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(listVtcv.moveToNext()) {
                    buffer.append("id: " + listVtcv.getString(0) + "\n");
                    buffer.append("Ma nhan vien: " + listVtcv.getString(1) + "\n");
                    buffer.append("Ma vi tri: " + listVtcv.getString(2) + "\n");
                    buffer.append("Thoi gian: " + listVtcv.getString(3) + "\n");
                    buffer.append("Ghi chu: " + listVtcv.getString(4) + "\n \n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(VitriCongViecActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Danh sach Cong viec");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}