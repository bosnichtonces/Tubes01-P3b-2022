package com.example.myapplication.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.DBHelper;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentMainBinding;
import com.example.myapplication.model.Dokter;
import com.example.myapplication.presenter.DokterPresenter;

import java.util.List;


public class MainFragment extends Fragment implements View.OnClickListener, DokterPresenter.IMainActivity {
    FragmentMainBinding binding;
    MainActivity activity;
    DokterListAdapter adapter;
    DokterPresenter presenter;
    FragmentListener listener;
    DBHelper dbHelper;


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

        this.dbHelper = new DBHelper(this.getActivity());
        this.presenter = new DokterPresenter((DokterPresenter.IMainActivity)this,dbHelper);
        this.adapter = new DokterListAdapter(requireActivity());

        this.presenter.loadData();

        binding.btnBuatPertemuan.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View view) {
        if(view.getId() == binding.btnBuatPertemuan.getId()){
            this.activity.changePage(3);
        }
    }

    @Override
    public void updateList(List<Dokter> dokterList) {
        this.adapter.updateArray(dokterList);
    }
}