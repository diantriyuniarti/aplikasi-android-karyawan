package com.example.projectakhir_noval_dian_nofal;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.cardview.widget.CardView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = findViewById(R.id.toolbarDashboard);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Dashboard");
        }

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        // Tambahan: Hubungkan CardView sensor
        CardView cardSensor = findViewById(R.id.sensorActivity);
        cardSensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, sensorActivity.class);
                startActivity(intent);
            }
        });

        // Tambahan: Hubungkan CardView map
        CardView cardMap = findViewById(R.id.map);
        cardMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        // Tambahan: Hubungkan CardView Voice to Text
        CardView cardVoiceToText = findViewById(R.id.voiceToText);
        cardVoiceToText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SpeechRecognizer.class);
                startActivity(intent);
            }
        });

        // Mengatur ActionBarDrawerToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    // Menangani klik ikon home/hamburger untuk membuka/menutup drawer
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(navigationView)) {
                drawerLayout.closeDrawer(navigationView);
            } else {
                drawerLayout.openDrawer(navigationView);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Menangani klik item di navigation drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Tutup drawer setelah item dipilih
        drawerLayout.closeDrawer(navigationView);

        int id = item.getItemId();

        if (id == R.id.nav_accelerometer) {
            Toast.makeText(this, "Menu Accelerometer Diklik", Toast.LENGTH_SHORT).show();
            // Intent ke sensorActivity jika sudah ada
            // Intent intent = new Intent(DashboardActivity.this, sensorAktivity.class);
            // startActivity(intent);
        } else if (id == R.id.nav_proximity) {
            Toast.makeText(this, "Menu Proximity Diklik", Toast.LENGTH_SHORT).show();
            // TODO: Tambahkan kode untuk pindah ke Activity/Fragment Proximity
        } else if (id == R.id.nav_gyroscope) {
            Toast.makeText(this, "Menu Gyroscope Diklik", Toast.LENGTH_SHORT).show();
            // TODO: Tambahkan kode untuk pindah ke Activity/Fragment Gyroscope
        } else if (id == R.id.nav_maps) {
            Toast.makeText(this, "Menu Maps Diklik", Toast.LENGTH_SHORT).show();
            // Intent ke MapActivity jika sudah ada
            // Intent intent = new Intent(DashboardActivity.this, MapActivity.class);
            // startActivity(intent);
        } else if (id == R.id.nav_input_karyawan) {
            // Menu untuk input data karyawan
            Intent intent = new Intent(DashboardActivity.this, InputDataKaryawanActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_lihat_karyawan) {
            // Menu untuk lihat data karyawan
            Intent intent = new Intent(DashboardActivity.this, LihatDataActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {
            // Logout - kembali ke MainActivity
            Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            Toast.makeText(this, "Logout berhasil", Toast.LENGTH_SHORT).show();
            finish();
        }

        return true;
    }

    // Menutup drawer saat tombol back ditekan jika drawer sedang terbuka
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView);
        } else {
            super.onBackPressed();
        }
    }
}
