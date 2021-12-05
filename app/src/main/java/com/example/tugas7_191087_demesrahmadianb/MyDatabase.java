package com.example.tugas7_191087_demesrahmadianb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_penjualan";
    private static final String tb_penjualan = "tb_penjualan";
    private static final String tb_penjualan_id = "id";
    private static final String tb_penjualan_nama = "nama";
    private static final String tb_penjualan_stok = "stok";
    private static final String tb_penjualan_jenis = "jenis";
    private static final String CREATE_TABLE_PENJUALAN = "CREATE TABLE " + tb_penjualan +"("
            + tb_penjualan_id + " INTEGER PRIMARY KEY ,"
            + tb_penjualan_nama + " TEXT ,"
            + tb_penjualan_stok + " TEXT ,"
            + tb_penjualan_jenis + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PENJUALAN);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreatePenjualan(Penjualan data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_penjualan_id, data.get_id());
        values.put(tb_penjualan_nama, data.get_nama());
        values.put(tb_penjualan_stok, data.get_stok());
        values.put(tb_penjualan_jenis, data.get_jenis());
        db.insert(tb_penjualan, null, values);
        db.close();
    }
    public List<Penjualan> ReadPenjualan() {
        List<Penjualan> listMhs = new ArrayList<Penjualan>();
        String selectQuery = "SELECT * FROM " + tb_penjualan;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Penjualan data = new Penjualan();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_stok(cursor.getString(2));
                data.set_jenis(cursor.getString(3));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdatePenjualan (Penjualan data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_penjualan_nama, data.get_nama());
        values.put(tb_penjualan_stok, data.get_stok());
        values.put(tb_penjualan_jenis, data.get_jenis());
        return db.update(tb_penjualan, values, tb_penjualan_id + " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeletePenjualan(Penjualan data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_penjualan,tb_penjualan_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}