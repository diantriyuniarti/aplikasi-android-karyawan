package com.example.projectakhir_noval_dian_nofal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Karyawan.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "karyawan";
    private static final String COL_ID = "id";
    private static final String COL_NIK = "nik";
    private static final String COL_NAMA = "nama";
    private static final String COL_JABATAN = "jabatan";
    private static final String COL_GAJI = "gaji";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NIK + " TEXT, " +
                COL_NAMA + " TEXT, " +
                COL_JABATAN + " TEXT, " +
                COL_GAJI + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // CREATE - Menambah data karyawan
    public boolean insertData(String nik, String nama, String jabatan, String gaji) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NIK, nik);
        values.put(COL_NAMA, nama);
        values.put(COL_JABATAN, jabatan);
        values.put(COL_GAJI, gaji);
        long result = db.insert(TABLE_NAME, null, values);
        return result != -1;
    }

    // READ - Mengambil semua data karyawan
    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    // UPDATE - Mengubah data karyawan
    public boolean updateData(String id, String nik, String nama, String jabatan, String gaji) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NIK, nik);
        values.put(COL_NAMA, nama);
        values.put(COL_JABATAN, jabatan);
        values.put(COL_GAJI, gaji);
        int result = db.update(TABLE_NAME, values, COL_ID + "=?", new String[]{id});
        return result > 0;
    }

    // DELETE - Menghapus data karyawan
    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, COL_ID + "=?", new String[]{id});
    }

    // Method tambahan untuk mencari karyawan berdasarkan NIK
    public Cursor getKaryawanByNik(String nik) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_NIK + "=?", new String[]{nik});
    }

    // Method untuk menambahkan data dummy
    public void insertDummyData() {
        insertData("KAR001", "Budi Santoso", "Manager", "8000000");
        insertData("KAR002", "Siti Nurhaliza", "Staff IT", "5500000");
        insertData("KAR003", "Ahmad Fauzi", "HRD", "6000000");
        insertData("KAR004", "Dewi Kartika", "Finance", "5800000");
        insertData("KAR005", "Andi Wijaya", "Marketing", "5200000");
    }
}
