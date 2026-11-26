# 📱 Aplikasi Manajemen & Presensi Karyawan Berbasis Android

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white)](https://developer.android.com/)
[![Java](https://img.shields.io/badge/Language-Java-ED8B00?logo=openjdk&logoColor=white)](https://www.java.com/)
[![SQLite](https://img.shields.io/badge/Database-SQLite-003B57?logo=sqlite&logoColor=white)](https://sqlite.org/)
[![Google Maps](https://img.shields.io/badge/Service-Google%20Maps%20API-4285F4?logo=google-maps&logoColor=white)](https://developers.google.com/maps)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

> **Aplikasi Mobile Android untuk Manajemen Data Karyawan, Pelacakan Lokasi (Maps), Sensor Perangkat, dan Pengenalan Suara (Speech Recognition).**  
> Dikembangkan oleh **Dian Tri Yuniarti, dkk.** sebagai proyek akhir mata kuliah Pemrograman Mobile (Universitas Pamulang).

---

## 🌟 Fitur Utama

- **🔐 Registrasi & Otentikasi Pengguna**:
  - Pendaftaran akun baru dan login aman dengan validasi form lokal.
- **👥 CRUD Data Karyawan (Create, Read, Update, Delete)**:
  - Input biodata karyawan, jabatan, kontak, dan departemen.
  - Tampilan daftar karyawan interaktif menggunakan `RecyclerView` dan custom `KaryawanAdapter`.
- **📍 Integrasi Google Maps API (`MapActivity`)**:
  - Pelacakan koordinat lokasi kantor / presensi karyawan berbasis peta digital.
- **🎙️ Fitur Speech Recognition (`SpeechRecognizer`)**:
  - Fitur perintah suara untuk pencarian atau pengisian data cepat melalui mikrofon smartphone.
- **🧭 Integrasi Sensor Smartphone (`sensorActivity`)**:
  - Pembacaan sensor perangkat mobile untuk utilitas pendukung aplikasi.
- **💾 Basis Data Lokal SQLite (`DatabaseHelper`)**:
  - Penyimpanan data offline-first yang andal dan ringan tanpa membutuhkan koneksi internet konstan.

---

## 💻 Tech Stack

- **Platform**: Android OS
- **Bahasa Pemrograman**: Java
- **IDE**: Android Studio
- **Build System**: Gradle (Kotlin DSL / Groovy)
- **Database**: SQLite (Android Native SQLiteOpenHelper)
- **APIs & SDKs**: Google Play Services (Maps), Android Sensor Framework, SpeechRecognizer API

---

## 🚀 Panduan Menjalankan

1. **Clone repository ini:**
   ```bash
   git clone git@github.com:diantriyuniarti/aplikasi-android-karyawan.git
   ```
2. Buka **Android Studio**.
3. Pilih **Open an Existing Project** dan arahkan ke folder `aplikasi-android-karyawan`.
4. Tunggu proses **Gradle Sync** hingga selesai.
5. Jalankan aplikasi pada **Emulator Android** atau perangkat HP fisik dengan mode USB Debugging aktif.

---

## 👩‍💻 Pengembang

**Dian Tri Yuniarti**  
- Lulusan S1 Teknik Informatika — Universitas Pamulang (IPK: 3.65)  
- Portofolio Resmi: [diantriyuniarti.github.io](https://diantriyuniarti.github.io)  
- LinkedIn: [Dian Tri Yuniarti](https://linkedin.com/in/diantriyuniarti)  
- Email: `diantriyuniarti025@gmail.com`
