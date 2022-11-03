package com.example.myapplication.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.DBHelper;
import com.example.myapplication.databinding.FragmentBuatDokterBinding;
import com.example.myapplication.databinding.FragmentBuatPertemuanBinding;

public class BuatDokterFragment extends Fragment {
    FragmentListener listener;
    FragmentBuatDokterBinding binding;
    DBHelper dbHelper;

    public BuatDokterFragment(){
    }

    public static BuatDokterFragment newInstace(){
        BuatDokterFragment fragment = new BuatDokterFragment();
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        binding = FragmentBuatDokterBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        this.dbHelper = new DBHelper(this.getActivity());

        binding.btnSimpan.setOnClickListener(this::isAdded);


        return view;
    }

    private void isAdded(View view) {
        if(view == binding.btnSimpan){
            String namaDokter = binding.etNewNama.getText().toString();
            String newSpesialis = binding.etSpesialis.getText().toString();
            
        }

    }
}
