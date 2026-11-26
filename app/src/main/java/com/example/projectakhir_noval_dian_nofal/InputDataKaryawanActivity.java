package com.example.projectakhir_noval_dian_nofal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class InputDataKaryawanActivity extends AppCompatActivity {
    EditText etNik, etNama, etJabatan, etGaji;
    Button btnSave;
    DatabaseHelper db;
    String karyawanId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_karyawan);

        // Inisialisasi views
        etNik = findViewById(R.id.etNik);
        etNama = findViewById(R.id.etNama);
        etJabatan = findViewById(R.id.etJabatan);
        etGaji = findViewById(R.id.etGaji);
        btnSave = findViewById(R.id.btnSave);

        db = new DatabaseHelper(this);

        // Cek apakah ini mode edit atau tambah baru
        if (getIntent().hasExtra("ID")) {
            karyawanId = getIntent().getStringExtra("ID");
            etNik.setText(getIntent().getStringExtra("NIK"));
            etNama.setText(getIntent().getStringExtra("NAMA"));
            etJabatan.setText(getIntent().getStringExtra("JABATAN"));
            etGaji.setText(getIntent().getStringExtra("GAJI"));
            btnSave.setText("Update");
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nik = etNik.getText().toString().trim();
                String nama = etNama.getText().toString().trim();
                String jabatan = etJabatan.getText().toString().trim();
                String gaji = etGaji.getText().toString().trim();

                if (nik.isEmpty() || nama.isEmpty() || jabatan.isEmpty() || gaji.isEmpty()) {
                    Toast.makeText(InputDataKaryawanActivity.this,
                            "Semua field harus diisi!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validasi format gaji (harus angka)
                try {
                    Double.parseDouble(gaji);
                } catch (NumberFormatException e) {
                    Toast.makeText(InputDataKaryawanActivity.this,
                            "Format gaji tidak valid!", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean result;
                if (karyawanId.isEmpty()) {
                    // Mode tambah baru
                    result = db.insertData(nik, nama, jabatan, gaji);
                    if (result) {
                        Toast.makeText(InputDataKaryawanActivity.this,
                                "Data karyawan berhasil ditambahkan!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(InputDataKaryawanActivity.this,
                                "Gagal menambahkan data karyawan!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Mode update
                    result = db.updateData(karyawanId, nik, nama, jabatan, gaji);
                    if (result) {
                        Toast.makeText(InputDataKaryawanActivity.this,
                                "Data karyawan berhasil diupdate!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(InputDataKaryawanActivity.this,
                                "Gagal mengupdate data karyawan!", Toast.LENGTH_SHORT).show();
                    }
                }

                if (result) {
                    finish(); // Kembali ke activity sebelumnya
                }
            }
        });
    }
}
