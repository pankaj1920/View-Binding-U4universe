package com.example.viewbindingu4universe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.viewbindingu4universe.Fragment.FragmentActivity;
import com.example.viewbindingu4universe.RecyclerViewActivity.RecyclerViewActivity;
import com.example.viewbindingu4universe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.helloTxt.setText("This is View Binding");

//        View binding in include layout we have to give id to include layout in mainActivity in xml
        binding.includeLayout.tvIncludeOutput.setText("View Binding in Include Layout");

        binding.goToFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intent);
            }
        });

        binding.goToRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}