package com.trivia.app.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.trivia.app.R;
import com.trivia.app.databinding.ActivityMainBinding;
import com.trivia.app.ui.fragments.Fragment01;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //Initializing the fragment
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //Replace the contents of the container with the new fragment
        ft.replace(R.id.fragment_container, new Fragment01());
        ft.commit();
    }
}