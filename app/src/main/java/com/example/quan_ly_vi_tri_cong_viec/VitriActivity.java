package com.example.quan_ly_vi_tri_cong_viec;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.quan_ly_vi_tri_cong_viec.models.ViTri;

public class VitriActivity extends AppCompatActivity {
    private EditText tenvt, motavt;
    private Button btn_addvt, btn_viewvt;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitri);

        DB = new DBHelper(this);

        tenvt = findViewById(R.id.ten_vi_tri);
        motavt = findViewById(R.id.mota);

        btn_addvt = findViewById(R.id.btn_addvt);
        btn_viewvt = findViewById(R.id.btn_viewvt);

        btn_addvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = tenvt.getText().toString();
                String mota = motavt.getText().toString();

                ViTri viTri = new ViTri(ten, mota);
                Boolean checkInsertVitri = DB.insertVitri(viTri);
                if (checkInsertVitri == true) {
                    Toast.makeText(VitriActivity.this, "Add vi tri thanh cong", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(VitriActivity.this, "Add vi tri khong thanh cong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_viewvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getViTri();
                if (res.getCount() == 0) {
                    Toast.makeText(VitriActivity.this, "Khong tim thay vi tri nao", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()) {
                    buffer.append("Ma vi tri: " + res.getString(0) + "\n");
                    buffer.append("Ten vi tri: " + res.getString(1) + "\n");
                    buffer.append("MO ta vi tri: " + res.getString(2) + "\n \n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(VitriActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Danh sach vi tri");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}