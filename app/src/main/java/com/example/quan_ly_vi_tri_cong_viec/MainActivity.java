package com.example.quan_ly_vi_tri_cong_viec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Button btn_qlnv, btn_qlvitri, btn_qlvitricv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_qlnv = findViewById(R.id.btn_qlnhanvien);
        btn_qlvitri = findViewById(R.id.btn_qlvitri);
        btn_qlvitricv = findViewById(R.id.btn_qlvitricv);

        btn_qlnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NhanVienActivity.class);
                startActivity(intent);
            }
        });

        btn_qlvitri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VitriActivity.class);
                startActivity(intent);
            }
        });

        btn_qlvitricv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, VitriCongViecActivity.class);
                startActivity(intent);
            }
        });
    }
}