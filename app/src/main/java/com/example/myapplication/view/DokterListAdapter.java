package com.example.myapplication.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.Dokter;

import java.util.ArrayList;
import java.util.List;

public class DokterListAdapter extends BaseAdapter {

    private List<Dokter> dokterList;
    private Activity activity;

    public DokterListAdapter(Activity activity){
        this.dokterList = new ArrayList<Dokter>();
        this.activity = activity;
    }

    private class ViewHolder{
        private TextView tvNamaDokter,tvNamaSpesialis;
        public ViewHolder(View view){
            this.tvNamaDokter = view.findViewById(R.id.tv_nama_dokter);
            this.tvNamaSpesialis = view.findViewById(R.id.tv_nama_spesialis);
        }
    }

    public void addLine(Dokter newDokter){
        this.dokterList.add(newDokter);
        this.notifyDataSetChanged();
    }

    public void updateArray(List<Dokter> dokters){
        this.dokterList = dokters;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.dokterList.size();
    }

    @Override
    public Object getItem(int i) {
        return dokterList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View convertView = LayoutInflater.from(this.activity).inflate(R.layout.item_dokter_list,viewGroup,false);
        Dokter currDokter = (Dokter) this.getItem(i);
        Dokter currSpesialis = (Dokter) this.getItem(i);

        ViewHolder viewHolder = new ViewHolder(convertView);
        viewHolder.tvNamaDokter.setText(currDokter.getNama_dokter());
        viewHolder.tvNamaSpesialis.setText(currSpesialis.getSpesialis());

        return convertView;
    }
}