package com.example.projectakhir_noval_dian_nofal;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class LihatDataActivity extends AppCompatActivity {
    DatabaseHelper db;
    ListView listView;
    ArrayList<Karyawan> karyawanList = new ArrayList<>();
    KaryawanAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        // Set title untuk ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Daftar Karyawan");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        db = new DatabaseHelper(this);
        listView = findViewById(R.id.listView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        karyawanList.clear();
        Cursor cursor = db.getAllData();

        if (cursor.moveToFirst()) {
            do {
                Karyawan karyawan = new Karyawan(
                        cursor.getString(0), // id
                        cursor.getString(1), // nik
                        cursor.getString(2), // nama
                        cursor.getString(3), // jabatan
                        cursor.getString(4)  // gaji
                );
                karyawanList.add(karyawan);
            } while (cursor.moveToNext());
        }
        cursor.close();

        adapter = new KaryawanAdapter(this, karyawanList);
        listView.setAdapter(adapter);

        // Tampilkan pesan jika tidak ada data
        if (karyawanList.isEmpty()) {
            Toast.makeText(this, "Belum ada data karyawan", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lihat_data, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else if (item.getItemId() == R.id.action_add_dummy) {
            // Tambah data dummy
            db.insertDummyData();
            loadData();
            Toast.makeText(this, "Data dummy berhasil ditambahkan", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
