package com.example.tugas7_191087_demesrahmadianb;

public class Penjualan {
    private String _id, _nama, _stok, _jenis;
    public Penjualan (String id, String nama, String stok, String jenis) {
        this._id = id;
        this._nama = nama;
        this._stok = stok;
        this._jenis = jenis;
    }
    public Penjualan() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_stok() {
        return _stok;
    }
    public void set_stok(String _stok) {
        this._stok = _stok;
    }
    public String get_jenis() {
        return _jenis;
    }
    public void set_jenis(String _jenis) {
        this._jenis = _jenis;
    }
}