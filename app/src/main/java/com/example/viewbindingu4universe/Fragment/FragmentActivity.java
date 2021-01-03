package com.example.viewbindingu4universe.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.viewbindingu4universe.R;
import com.example.viewbindingu4universe.databinding.ActivityFragmentBinding;

public class FragmentActivity extends AppCompatActivity {

    ActivityFragmentBinding activityFragmentBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fragment);
        activityFragmentBinding = ActivityFragmentBinding.inflate(getLayoutInflater());
        setContentView(activityFragmentBinding.getRoot());

        Fragment fragment = new BlankFragment();
        getSupportFragmentManager().beginTransaction()
        .add(R.id.fragmentContainer,fragment)
        .commit();
    }
}