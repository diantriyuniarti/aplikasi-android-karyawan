package com.example.projectakhir_noval_dian_nofal;

public class Karyawan {
    public String id, nik, nama, jabatan, gaji;

    public Karyawan(String id, String nik, String nama, String jabatan, String gaji) {
        this.id = id;
        this.nik = nik;
        this.nama = nama;
        this.jabatan = jabatan;
        this.gaji = gaji;
    }

    // Getter methods
    public String getId() { return id; }
    public String getNik() { return nik; }
    public String getNama() { return nama; }
    public String getJabatan() { return jabatan; }
    public String getGaji() { return gaji; }

    // Setter methods
    public void setId(String id) { this.id = id; }
    public void setNik(String nik) { this.nik = nik; }
    public void setNama(String nama) { this.nama = nama; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }
    public void setGaji(String gaji) { this.gaji = gaji; }
}
