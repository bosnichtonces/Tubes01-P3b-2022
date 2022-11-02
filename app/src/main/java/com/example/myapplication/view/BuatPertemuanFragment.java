package com.example.myapplication.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.DBHelper;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentBuatPertemuanBinding;

import java.sql.Timestamp;


public class BuatPertemuanFragment extends Fragment {
    FragmentBuatPertemuanBinding binding;
    DBHelper dbHelper;
    String newNama, newDokter, newKeluhan;
    Timestamp newTanggal,newWaktu;

    public BuatPertemuanFragment() {
        // Required empty public constructor
    }


    public static BuatPertemuanFragment newInstance() {
        BuatPertemuanFragment fragment = new BuatPertemuanFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBuatPertemuanBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        this.dbHelper = new DBHelper(this.getActivity());


        binding.btnSimpan.setOnClickListener(this::isAdded);
        return view;
    }

    private void isAdded(View view) {
        if(view == binding.btnSimpan){

        }
    }
}