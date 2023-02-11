package com.rizend.prueba_tecnica.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.rizend.prueba_tecnica.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}