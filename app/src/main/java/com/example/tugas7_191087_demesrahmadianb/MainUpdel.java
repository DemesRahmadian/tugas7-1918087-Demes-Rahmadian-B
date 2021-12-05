package com.example.tugas7_191087_demesrahmadianb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sstok, Sjenis;
    private EditText Enama, Estok, Ejenis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sstok = i.getStringExtra("IStok");
        Sjenis = i.getStringExtra("IJenis");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Estok = (EditText) findViewById(R.id.updel_stok);
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Enama.setText(Snama);
        Estok.setText(Sstok);
        Ejenis.setText(Sjenis);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sstok = String.valueOf(Estok.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama Produk",
                            Toast.LENGTH_SHORT).show();
                } else if (Sstok.equals("")){
                    Estok.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi stok Barang",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jenis Barang",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdatePenjualan(new Penjualan(Sid, Snama, Sstok, Sjenis));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeletePenjualan(new Penjualan(Sid, Snama, Sstok, Sjenis));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}