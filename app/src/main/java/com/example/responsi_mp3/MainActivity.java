package com.example.responsi_mp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.responsi_mp3.Fragment.History_Fragment;
import com.example.responsi_mp3.Fragment.Home_Fragment;
import com.example.responsi_mp3.Fragment.Payment_Fragment;
import com.example.responsi_mp3.Fragment.Setting_Fragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_CAMERA = 1;
    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ChipNavigationBar chipNavigationBar = findViewById(R.id.chipNavigation);

        chipNavigationBar.setItemSelected(R.id.home, true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home_Fragment()).commit();

        chipNavigationBar.setOnItemSelectedListener(i -> {
            switch (i) {
                case R.id.home:
                    fragment = new Home_Fragment();
                    break;
                case R.id.payment:
                    fragment = new Payment_Fragment();
                    break;
                case R.id.hstory:
                    fragment = new History_Fragment();
                    break;
                case R.id.setting:
                    fragment = new Setting_Fragment();
                    break;
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            }
        });
        initFunctionality();
    }
    private void initFunctionality() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_CAMERA);

        }
}