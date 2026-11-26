package com.example.projectakhir_noval_dian_nofal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    Button btnRegister;
    TextView tvLoginHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btnlogin); // Menggunakan ID btnlogin dari layout register
        tvLoginHere = findViewById(R.id.tvLoginHere);

        // Listener untuk tombol Register (gimmick)
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Di sini Anda bisa menambahkan logika validasi input jika perlu,
                // tapi untuk gimmick, langsung tampilkan Toast.
                Toast.makeText(RegisterActivity.this, "Register Berhasil!", Toast.LENGTH_SHORT).show();
                // Opsional: Kembali ke halaman login setelah register berhasil (jika diinginkan)
                // Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                // startActivity(intent);
                // finish();
            }
        });

        // Listener untuk TextView "Login here"
        tvLoginHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Tutup RegisterActivity
            }
        });
    }
}
