package com.example.myapplication.view;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.databinding.FragmentDetailDokterBinding;
import com.example.myapplication.model.Dokter;

public class MainActivity extends AppCompatActivity implements FragmentListener{
    ActivityMainBinding binding;
    BuatPertemuanFragment buatPertemuanFragment;
    DokterFragment dokterFragment;
    MainFragment mainFragment;
    PertemuanFragment pertemuanFragment;
    DetailDokterFragment detailDokterFragment;
    EditFragment editFragment;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.setSupportActionBar(this.binding.toolbar);
        ActionBarDrawerToggle abdt = new ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar,0,0);
        binding.drawerLayout.addDrawerListener(abdt);
        abdt.syncState();

        this.fragmentManager = this.getSupportFragmentManager();
        this.buatPertemuanFragment = BuatPertemuanFragment.newInstance();
        this.dokterFragment = DokterFragment.newInstance();
        this.mainFragment = MainFragment.newInstance();
        this.pertemuanFragment = PertemuanFragment.newInstance();

        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment fr = fragmentManager.findFragmentById(R.id.dokter_list);
                if (ft != null){
                    Log.e("fragment = ",fr.getClass().getSimpleName());
                }
            }
        });
        ft.add(R.id.fragment_container,this.mainFragment).addToBackStack(null)
                .commit();
    }


    @Override
    public void changePage(int page) {
        this.fragmentTransaction = this.fragmentManager.beginTransaction();

        if(page == 1){
            fragmentTransaction.replace(R.id.fragment_container,this.mainFragment)
                    .addToBackStack(null);
        }else if(page == 2){
            fragmentTransaction.replace(R.id.fragment_container,this.dokterFragment)
                    .addToBackStack(null);
        }else if(page == 3){
            fragmentTransaction.replace(R.id.fragment_container,this.buatPertemuanFragment)
                    .addToBackStack(null);
        }else if(page == 4){
            fragmentTransaction.replace(R.id.fragment_container,this.pertemuanFragment)
                    .addToBackStack(null);
        }else if(page == 5){
            fragmentTransaction.replace(R.id.fragment_container,this.detailDokterFragment)
                    .addToBackStack(null);
        }else if(page == 6){
            fragmentTransaction.replace(R.id.fragment_container,this.editFragment)
                    .addToBackStack(null);
        }
        this.fragmentTransaction.commit();
        binding.drawerLayout.closeDrawers();
    }

    @Override
    public void closeApplication() {
        this.moveTaskToBack(true);
        this.finish();
        binding.drawerLayout.closeDrawers();
    }

    public void passMenu(Dokter dokter) {
        this.fragmentTransaction = this.fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putParcelable("dokter",dokter);
        this.detailDokterFragment.setArguments(bundle);
        changePage(5);

    }

    public void passEdit(Dokter dokter) {
        this.fragmentTransaction = this.fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putParcelable("editDokter",dokter);
        changePage(6);
    }
}