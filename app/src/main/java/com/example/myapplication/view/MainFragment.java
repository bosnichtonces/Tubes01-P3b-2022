package com.example.myapplication.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentMainBinding;


public class MainFragment extends Fragment implements View.OnClickListener {
    FragmentMainBinding binding;
    MainActivity activity;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        binding.btnBuatPertemuan.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == binding.btnBuatPertemuan.getId()){
            this.activity.changePage(3);
        }
    }
}