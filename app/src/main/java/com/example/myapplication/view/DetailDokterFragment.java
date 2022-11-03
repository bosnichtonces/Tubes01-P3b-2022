package com.example.myapplication.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.myapplication.DBHelper;
import com.example.myapplication.databinding.FragmentDetailDokterBinding;
import com.example.myapplication.model.Dokter;

public class DetailDokterFragment extends Fragment {
    FragmentDetailDokterBinding binding;
    FragmentManager fragmentManager;
    FragmentListener listener;
    DBHelper dbHelper;

    Dokter dokter;

    public DetailDokterFragment(){

    }

    public static DetailDokterFragment newInstance(){
        DetailDokterFragment fragment = new DetailDokterFragment();
        return fragment;
    }


    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        binding = FragmentDetailDokterBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        binding.fabEdit.setOnClickListener(this::onClick);
        Bundle b = getArguments();
        if(b != null){
            this.dokter = b.getParcelable("dokter");
            binding.detailsTitle.setText(dokter.getNama_dokter());
            binding.detailsSpesialis.setText(dokter.getSpesialis());
        }


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListener) {
            this.listener = (FragmentListener) context;
        } else {
            throw new ClassCastException(context.toString() + " Must Implement Fragment Listener");
        }
    }

    private void onClick(View view) {
        if(view.getId() == binding.fabEdit.getId()){
            MainActivity mn1 = (MainActivity) getActivity();
            mn1.passEdit(this.dokter);
        }
    }
}
