package com.example.myapplication.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentPertemuanBinding;

public class PertemuanFragment extends Fragment {
    FragmentPertemuanBinding binding;

    public PertemuanFragment(){

    }

    public static PertemuanFragment newInstance(){
        PertemuanFragment fragment = new PertemuanFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        binding = FragmentPertemuanBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        return view;
    }
}
