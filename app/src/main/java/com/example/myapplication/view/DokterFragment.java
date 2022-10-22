package com.example.myapplication.view;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDokterBinding;


public class DokterFragment extends Fragment {
    FragmentDokterBinding binding;


    public DokterFragment() {
    }

    public static DokterFragment newInstance() {
        DokterFragment fragment = new DokterFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDokterBinding.inflate(inflater,container,false);
        View view = binding.getRoot();


        return view;
    }
}