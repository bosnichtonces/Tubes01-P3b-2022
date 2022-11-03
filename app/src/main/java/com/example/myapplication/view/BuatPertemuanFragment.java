package com.example.myapplication.view;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.database.sqlite.SQLiteCursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.DBHelper;
import com.example.myapplication.databinding.FragmentBuatPertemuanBinding;
import com.example.myapplication.model.Dokter;

import java.util.Calendar;


public class BuatPertemuanFragment extends Fragment {
    FragmentBuatPertemuanBinding binding;
    FragmentListener listener;
    DBHelper dbHelper;
    DatePickerDialog picker;
    private String[] jam = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
            "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" };

    public BuatPertemuanFragment() {
        // Required empty public constructor
    }


    public static BuatPertemuanFragment newInstance() {
        BuatPertemuanFragment fragment = new BuatPertemuanFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBuatPertemuanBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        showSpinnerTime();

        binding.spinnerDokter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SQLiteCursor item = (SQLiteCursor) adapterView.getItemAtPosition(i);
                String value = String.valueOf(item.getString(1));
                Toast.makeText(getContext(), "The option is:" + value , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        
        this.dbHelper = new DBHelper(this.getActivity());


        binding.btnSimpan.setOnClickListener(this::isAdded);
        return view;
    }

    private void showSpinnerTime() {
        Spinner spin_time = binding.spinnerWaktu;
        ArrayAdapter a_spin_time = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, jam);
        a_spin_time.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_time.setAdapter(a_spin_time);
    }


    private void isAdded(View view) {
        if(view == binding.btnSimpan){
            String newNama = binding.etNewNama.getText().toString();
            String newDokter= binding.spinnerDokter.getSelectedItem().toString();
            String newSpesialis = "";
            String newKeluhan = binding.etNewKeluhan.getText().toString();
            String newTanggal = binding.etNewTanggal.getText().toString();
            String newTime = binding.spinnerWaktu.getSelectedItem().toString();
            String newStatus = "";

            Dokter item  = new Dokter(0,newNama,newDokter,newSpesialis,newKeluhan,newTanggal,newTime,newStatus);
            this.dbHelper.addRecord(item);
            this.hideKeyboard(getActivity());
            listener.changePage(2);
            binding.etNewNama.setText(null);
            binding.etNewKeluhan.setText(null);
        }
        else if(view == binding.etNewTanggal){
            showDatePicker();
        }
    }

    private void showDatePicker() {
        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
        //date picker dialog
        picker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String tanggal = Integer.toString(dayOfMonth);
                month++;
                String bulan = Integer.toString(month);
                if(tanggal.length() == 1){
                    tanggal = "0" + Integer.toString(dayOfMonth);
                }
                if(bulan.length() == 1){
                    bulan = "0" + Integer.toString(month);
                }

                binding.etNewTanggal.setText(tanggal + "-" + (bulan) + "-" + year);
            }
        }, year, month, day);
        picker.show();
    }

    private void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }
}