package com.example.tugas7_191087_demesrahmadianb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Penjualan> ListPenjualan = new ArrayList<Penjualan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListPenjualan);
        mListView = (ListView) findViewById(R.id.list_penjualan);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListPenjualan.clear();
        List<Penjualan> penjualan = db.ReadPenjualan();
        for (Penjualan mhs : penjualan) {
           Penjualan daftar = new Penjualan();
            daftar.set_id(mhs.get_id());
            daftar.set_nama(mhs.get_nama());
            daftar.set_stok(mhs.get_stok());
            daftar.set_jenis(mhs.get_jenis());
            ListPenjualan.add(daftar);
            if ((ListPenjualan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Penjualan detailMhs = (Penjualan) o;
        String Sid = detailMhs.get_id();
        String Snama = detailMhs.get_nama();
        String Sstok = detailMhs.get_stok();
        String Sjenis = detailMhs.get_jenis();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Istok", Sstok);
        goUpdel.putExtra("IJenis", Sjenis);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListPenjualan.clear();
        mListView.setAdapter(adapter_off);
        List<Penjualan> penjualan = db.ReadPenjualan();
        for (Penjualan mhs : penjualan) {
            Penjualan daftar = new Penjualan();
            daftar.set_id(mhs.get_id());
            daftar.set_nama(mhs.get_nama());
            daftar.set_stok(mhs.get_stok());
            daftar.set_jenis(mhs.get_jenis());
            ListPenjualan.add(daftar);
            if ((ListPenjualan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}