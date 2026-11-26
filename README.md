# Aplikasi Manajemen dan Presensi Karyawan Berbasis Android

Mata Kuliah: Pemrograman Mobile  
Program Studi S1 Teknik Informatika, Universitas Pamulang  
Pengembang: Dian Tri Yuniarti, dkk.

---

## Deskripsi Aplikasi

Aplikasi mobile berbasis Android native untuk mendukung administrasi ketenagakerjaan, mencakup pencatatan data karyawan, penentuan titik lokasi kehadiran berbasis peta digital, perekaman input suara, serta pembacaan sensor smartphone.

Data karyawan disimpan secara lokal pada perangkat menggunakan basis data embedded SQLite untuk memastikan aplikasi tetap dapat beroperasi secara offline.

---

## Fitur Utama

1. Autentikasi Pengguna
   * Form pendaftaran akun baru (RegisterActivity)
   * Login pengguna dengan validasi input (MainActivity)

2. Manajemen Data Karyawan (CRUD)
   * Input biodata karyawan, NIK, jabatan, dan nomor telepon
   * Tampilan daftar karyawan interaktif menggunakan RecyclerView dan KaryawanAdapter
   * Pencarian, pengeditan, dan penghapusan data karyawan

3. Integrasi Peta Digital (Google Maps API)
   * Penandaan koordinat geografis (latitude dan longitude) lokasi presensi (MapActivity)

4. Pengenalan Suara (Speech Recognition)
   * Konversi input suara mikrofon menjadi teks untuk pencarian atau pengisian formulir cepat (SpeechRecognizer)

5. Integrasi Sensor Smartphone
   * Pembacaan sensor perangkat melalui Android Sensor Framework (sensorActivity)

---

## Arsitektur Teknologi

* Platform: Android OS
* Bahasa Pemrograman: Java
* IDE: Android Studio
* Build System: Gradle
* Basis Data Lokal: SQLite (SQLiteOpenHelper)
* Pustaka Eksternal: Google Play Services Maps, Android Sensor API, Android SpeechRecognizer

---

## Struktur Direktori

```text
aplikasi-android-karyawan/
├── app/
│   ├── src/main/java/com/example/projectakhir_noval_dian_nofal/
│   │   ├── DashboardActivity.java        # Navigasi utama
│   │   ├── DatabaseHelper.java           # Pengendali skema dan query SQLite
│   │   ├── InputDataKaryawanActivity.java# Formulir input data
│   │   ├── Karyawan.java                 # Model entitas data karyawan
│   │   ├── KaryawanAdapter.java          # Adapter viewholder RecyclerView
│   │   ├── LihatDataActivity.java        # List view data karyawan
│   │   ├── MainActivity.java             # Form login
│   │   ├── MapActivity.java              # Integrasi Google Maps
│   │   ├── RegisterActivity.java         # Form registrasi
│   │   ├── sensorActivity.java           # Pembacaan sensor
│   │   └── SpeechRecognizer.java         # Pengenalan suara
│   └── src/main/res/                     # Layout XML, drawable, dan nilai strings
├── build.gradle.kts
└── README.md
```

---

## Panduan Menjalankan

1. Clone repositori:
   ```bash
   git clone git@github.com:diantriyuniarti/aplikasi-android-karyawan.git
   ```

2. Buka Android Studio dan pilih menu **Open** pada direktori repositori.

3. Tunggu proses sinkronisasi Gradle (Gradle Sync) selesai.

4. Jalankan aplikasi pada Android Emulator atau perangkat fisik yang terhubung via USB Debugging.
