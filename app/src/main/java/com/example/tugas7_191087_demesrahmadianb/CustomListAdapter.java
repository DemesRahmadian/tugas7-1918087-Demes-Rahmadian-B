package com.example.tugas7_191087_demesrahmadianb;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Penjualan> Penjualan;
    public CustomListAdapter(Activity activity, List<Penjualan> Penjualan) {
        this.activity = activity;
        this.Penjualan = Penjualan;
    }
    @Override
    public int getCount() {
        return Penjualan.size();
    }
    @Override
    public Object getItem(int location) {
        return Penjualan.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView stok = (TextView)
                convertView.findViewById(R.id.text_stok);
        TextView jenis = (TextView)
                convertView.findViewById(R.id.text_jenis);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Penjualan m = Penjualan.get(position);
        nama.setText("Nama : "+ m.get_nama());
        stok.setText("Stok Barang : "+ m.get_stok());
        jenis.setText("Jenis Barang : "+ m.get_jenis());
        return convertView;
    }
}