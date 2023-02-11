package com.rizend.prueba_tecnica.view;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.rizend.prueba_tecnica.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    public static ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        actionBar = getSupportActionBar();
        setContentView(binding.getRoot());
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

}