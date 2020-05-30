package com.medecard.user.medecard_patient;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.medecard.user.medecard_patient.fragments.HomeFragment;
import com.medecard.user.medecard_patient.fragments.PersInfoFragment;
import com.medecard.user.medecard_patient.fragments.RecordsFragment;
import com.medecard.user.medecard_patient.fragments.SharingFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // -------- Bottom Navigation ----------- \\

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_home:
                                selectedFragment = HomeFragment.newInstance();
                                break;
//                            case R.id.navigation_pers_info:
//                                selectedFragment = PersInfoFragment.newInstance();
//                                break;
                            case R.id.navigation_records:
                                selectedFragment = RecordsFragment.newInstance();
                                break;
                            case R.id.navigation_share:
                                selectedFragment = SharingFragment.newInstance();
                                break;
                        }

                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });
        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeFragment.newInstance());
        transaction.commit();
        //Used to select an item programmatically
//        bottomNavigationView.getMenu().getItem(0).setChecked(true);
    }

}
