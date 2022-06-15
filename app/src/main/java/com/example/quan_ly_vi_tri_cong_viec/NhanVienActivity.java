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

import com.example.quan_ly_vi_tri_cong_viec.models.NhanVien;

public class NhanVienActivity extends AppCompatActivity {
    private EditText tennv, namsinh, quequan;
    private Button btn_addnv, btn_viewnv, btn_timnv;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);

        DB = new DBHelper(this);

        Spinner dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Cao dang", "Dai hoc", "Sau DH"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        tennv = findViewById(R.id.ten_nhan_vien);
        namsinh = findViewById(R.id.nam_sinh);
        quequan = findViewById(R.id.que_quan);

        btn_addnv = findViewById(R.id.btn_addnv);
        btn_viewnv = findViewById(R.id.btn_viewnv);
        btn_timnv = findViewById(R.id.btn_timnv);

        btn_addnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = tennv.getText().toString();
                String nam = namsinh.getText().toString();
                String que = quequan.getText().toString();
                String trinhdo = dropdown.getSelectedItem().toString();

                NhanVien nhanVien = new NhanVien(ten, nam, que, trinhdo);
                Boolean checkInsertNhanVien = DB.insertnv(nhanVien);
                if (checkInsertNhanVien == true) {
                    Toast.makeText(NhanVienActivity.this, "Add nhan vien oke", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NhanVienActivity.this, "Add nhan vien fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_viewnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getNhanVien();
                if (res.getCount() == 0) {
                    Toast.makeText(NhanVienActivity.this, "Khong tim thay nhan vien", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()) {
                    buffer.append("Ma nhan vien: " + res.getString(0) + "\n");
                    buffer.append("Ten nhan vien: " + res.getString(1) + "\n");
                    buffer.append("Nam sinh: " + res.getString(2) + "\n");
                    buffer.append("Que quan: " + res.getString(3) + "\n");
                    buffer.append("Trinh do: " + res.getString(4) + "\n \n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(NhanVienActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Danh sach Nhan Vien");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });

        btn_timnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.findNv();
                if (res.getCount() == 0) {
                    Toast.makeText(NhanVienActivity.this, "Khong tim thay nhan vien nao", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()) {
                    buffer.append("Ma nhan vien: " + res.getString(0) + "\n");
                    buffer.append("Ten nhan vien: " + res.getString(1) + "\n");
                    buffer.append("Nam sinh: " + res.getString(2) + "\n");
                    buffer.append("Que quan: " + res.getString(3) + "\n");
                    buffer.append("Trinh do: " + res.getString(4) + "\n \n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(NhanVienActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Nhan vien tim duoc: ");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}