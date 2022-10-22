package com.example.myapplication.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentBuatPertemuanBinding;


public class BuatPertemuanFragment extends Fragment {
    FragmentBuatPertemuanBinding binding;

    public BuatPertemuanFragment() {
        // Required empty public constructor
    }


    public static BuatPertemuanFragment newInstance() {
        BuatPertemuanFragment fragment = new BuatPertemuanFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBuatPertemuanBinding.inflate(inflater,container,false);
        View view = binding.getRoot();


        return view;
    }
}