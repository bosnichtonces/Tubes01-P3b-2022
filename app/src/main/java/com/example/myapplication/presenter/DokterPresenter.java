package com.example.myapplication.presenter;

import com.example.myapplication.DBHelper;
import com.example.myapplication.model.Dokter;

import java.util.ArrayList;
import java.util.List;

public class DokterPresenter {

    public interface IMainActivity{
        void update(List<Dokter> dokterList);
    }
    protected DBHelper dbHelper;
    protected List<Dokter> dokters;
    protected IMainActivity ui;

    public DokterPresenter(IMainActivity ui,DBHelper dbHelper){
        this.dokters = new ArrayList<>();
        this.ui = ui;
        this.dbHelper = dbHelper;
    }

}
