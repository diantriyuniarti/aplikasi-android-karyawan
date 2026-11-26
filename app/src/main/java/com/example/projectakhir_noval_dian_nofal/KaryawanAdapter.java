package com.example.projectakhir_noval_dian_nofal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class KaryawanAdapter extends BaseAdapter {
    Context context;
    ArrayList<Karyawan> karyawanList;
    DatabaseHelper db;

    public KaryawanAdapter(Context context, ArrayList<Karyawan> karyawanList) {
        this.context = context;
        this.karyawanList = karyawanList;
        db = new DatabaseHelper(context);
    }

    @Override
    public int getCount() {
        return karyawanList.size();
    }

    @Override
    public Object getItem(int position) {
        return karyawanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        TextView txtNik, txtNama, txtJabatan, txtGaji;
        Button btnEdit, btnDelete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Karyawan karyawan = karyawanList.get(position);
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_karyawan, parent, false);
            holder = new ViewHolder();
            holder.txtNik = convertView.findViewById(R.id.txtNik);
            holder.txtNama = convertView.findViewById(R.id.txtNama);
            holder.txtJabatan = convertView.findViewById(R.id.txtJabatan);
            holder.txtGaji = convertView.findViewById(R.id.txtGaji);
            holder.btnEdit = convertView.findViewById(R.id.btnEdit);
            holder.btnDelete = convertView.findViewById(R.id.btnDelete);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Format gaji ke Rupiah
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        String gajiFormatted = formatter.format(Double.parseDouble(karyawan.gaji));

        holder.txtNik.setText("NIK: " + karyawan.nik);
        holder.txtNama.setText("Nama: " + karyawan.nama);
        holder.txtJabatan.setText("Jabatan: " + karyawan.jabatan);
        holder.txtGaji.setText("Gaji: " + gajiFormatted);

        holder.btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(context, InputDataKaryawanActivity.class);
            intent.putExtra("ID", karyawan.id);
            intent.putExtra("NIK", karyawan.nik);
            intent.putExtra("NAMA", karyawan.nama);
            intent.putExtra("JABATAN", karyawan.jabatan);
            intent.putExtra("GAJI", karyawan.gaji);
            context.startActivity(intent);
        });

        holder.btnDelete.setOnClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle("Hapus Data Karyawan")
                    .setMessage("Yakin ingin menghapus data karyawan " + karyawan.nama + "?")
                    .setPositiveButton("Ya", (dialog, which) -> {
                        db.deleteData(karyawan.id);
                        karyawanList.remove(position);
                        notifyDataSetChanged();
                        Toast.makeText(context, "Data karyawan berhasil dihapus", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Tidak", null)
                    .show();
        });

        return convertView;
    }
}
