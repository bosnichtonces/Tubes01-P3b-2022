package com.example.myapplication.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.DBHelper;
import com.example.myapplication.databinding.FragmentEditBinding;
import com.example.myapplication.model.Dokter;

public class EditFragment extends Fragment {
    FragmentEditBinding binding;
    DBHelper dbHelper;
    Dokter dokter;
    FragmentListener listener;
    
    public EditFragment(){
        
    }
    
    public static EditFragment newInstace(){
        EditFragment fragment = new EditFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        binding = FragmentEditBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        dbHelper = new DBHelper(this.getActivity());

        binding.btnEdit.setOnClickListener(this::onEdit);
        binding.btnHapus.setOnClickListener(this::onDelete);


        Bundle b = getArguments();

        if(b != null){
            Dokter idDokter = b.getParcelable("editdokter");

            dokter = dbHelper.getContact(idDokter.getId());

            binding.etNamaDokter.setText(dokter.getNama_dokter());
            binding.etSpesialis.setText(dokter.getSpesialis());

        }
        
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof  FragmentListener){
            this.listener = (FragmentListener) context;
        }else{
            throw  new ClassCastException(context.toString() + "Must Implement Fragment Listener");
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        Bundle b = getArguments();

        binding.etNamaDokter.setText("");
        if (b != null){
            Dokter idDokter = b.getParcelable("editdokter");

            dokter = dbHelper.getContact(idDokter.getId());

            binding.etNamaDokter.setText(dokter.getNama_dokter());
            binding.etSpesialis.setText(dokter.getSpesialis());
        }

    }

    private void onDelete(View view) {
        if (view == binding.btnHapus){
            dbHelper.deleteRecord(this.dokter.getId());
        }
    }

    private void onEdit(View view) {
        if(view == binding.btnEdit){
            String newNama = binding.etNamaDokter.getText().toString();
            String newSpesialis = binding.etSpesialis.getText().toString();

            Dokter item = new Dokter(this.dokter.getId(),"",newNama,newSpesialis,"","","","");
            this.dbHelper.updateContact(item);
            this.listener.changePage(2);
            binding.etNamaDokter.setText(null);
            binding.etSpesialis.setText(null);

        }
    }


}
