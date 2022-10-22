package com.example.myapplication.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentLeftBinding;
import com.example.myapplication.presenter.DokterPresenter;


public class LeftFragment extends Fragment implements View.OnClickListener {
    FragmentListener listener;
    FragmentLeftBinding binding;
    MainActivity activity;
    private DokterPresenter presenter;
    private DokterListAdapter adapter;
    public LeftFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLeftBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        binding.home.setOnClickListener(this);
        binding.pertemuan.setOnClickListener(this);
        binding.dokter.setOnClickListener(this);
        binding.exit.setOnClickListener(this);
        this.activity = ((MainActivity) getActivity());
        return view;
    }

    public static LeftFragment newInstance(String title) {
        LeftFragment fragment = new LeftFragment();
        return fragment;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            this.listener = (FragmentListener) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement FragmentListener");
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == binding.home.getId()) {
            this.activity.changePage(1);
        } else if (v.getId() == binding.dokter.getId()) {
            this.activity.changePage(2);
        } else if (v.getId() == binding.exit.getId()) {
            this.activity.closeApplication();
        }
    }

}
