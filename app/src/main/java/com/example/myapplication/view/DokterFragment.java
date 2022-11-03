package com.example.myapplication.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.myapplication.DBHelper;
import com.example.myapplication.databinding.FragmentDokterBinding;
import com.example.myapplication.model.Dokter;
import com.example.myapplication.presenter.DokterPresenter;

import java.util.List;


public class DokterFragment extends Fragment implements DokterPresenter.IMainActivity, View.OnClickListener {
    FragmentDokterBinding binding;
    DokterListAdapter adapter;
    FragmentManager fragmentManager;
    FragmentListener listener;
    DokterPresenter presenter;
    DBHelper dbHelper;

    public DokterFragment() {
    }

    public static DokterFragment newInstance() {
        DokterFragment fragment = new DokterFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDokterBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        this.dbHelper = new DBHelper(this.getActivity());
        this.presenter = new DokterPresenter((DokterPresenter.IMainActivity)this,dbHelper);
        this.adapter = new DokterListAdapter(requireActivity());

        this.presenter.loadData();
        binding.listDokter.setAdapter(this.adapter);

        binding.fabAdd.setOnClickListener(this);
        binding.listDokter.setOnItemClickListener(this::onItemClick);

        return view;
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener = (FragmentListener) context;
        }else{
            throw new ClassCastException(context.toString()+ " Must Implement Fragment Listener");
        }
    }

    @Override
    public void updateList(List<Dokter> dokterList) {
        this.adapter.updateArray(dokterList);
    }

    @Override
    public void onClick(View view) {
        if(view == binding.fabAdd){
            listener.changePage(3);
        }
    }

    private void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        MainActivity mn1 = (MainActivity) getActivity();
        Dokter currentDokter  = (Dokter) adapter.getItem(i);
        mn1.passMenu(currentDokter);
    }
}