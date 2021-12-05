package com.example.tugas7_191087_demesrahmadianb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Estok, Ejenis;
    private String Snama, Sstok, Sjenis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Estok = (EditText) findViewById(R.id.create_stok);
        Ejenis= (EditText) findViewById(R.id.create_jenis);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sstok = String.valueOf(Estok.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama Skincare",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sstok.equals("")) {
                    Estok.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Stok Skincare",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sjenis.equals("")) {
                    Ejenis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Jenis Skincare",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Estok.setText("");
                    Ejenis.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreatePenjualan(new Penjualan(null, Snama, Sstok, Sjenis));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }


}
