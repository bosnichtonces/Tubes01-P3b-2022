package com.example.myapplication.presenter;

import com.example.myapplication.DBHelper;
import com.example.myapplication.model.Dokter;

import java.util.ArrayList;
import java.util.List;

public class DokterPresenter {

    public interface IMainActivity{
        void updateList(List<Dokter> dokterList);
    }
    protected DBHelper dbHelper;
    protected List<Dokter> dokters;
    protected IMainActivity ui;

    public DokterPresenter(IMainActivity ui,DBHelper dbHelper){
        this.dokters = new ArrayList<>();
        this.ui = ui;
        this.dbHelper = dbHelper;
    }

    public void loadData(){
        this.dokters=dbHelper.getAllRecord();
        this.ui.updateList(this.dokters);
    }

    public int countItem(){
        return dokters.size();
    }

    public void delete(int position){
        this.dokters.remove(position);
        this.ui.updateList(this.dokters);
    }

    public void addList(String nama_pasien, String nama_dokter,
                        String spesialis, String keluhan, String tanggal,
                        String waktu, String status){
        this.dokters.add(new Dokter(+1,nama_pasien,nama_dokter,spesialis,
                                    keluhan,tanggal,waktu, status));
        this.ui.updateList(this.dokters);
    }

}
