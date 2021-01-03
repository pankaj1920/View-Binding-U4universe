package com.example.viewbindingu4universe.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.viewbindingu4universe.R;
import com.example.viewbindingu4universe.databinding.FragmentBlankBinding;


public class BlankFragment extends Fragment {

    FragmentBlankBinding fragmentBlankBinding;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_blank, container, false);
        fragmentBlankBinding = FragmentBlankBinding.inflate(inflater,container,false);
        fragmentBlankBinding.tvFragment.setText("Hello from Blank Fragment. This is View Binding");

        View view = fragmentBlankBinding.getRoot();
        return view;
    }


//    Make sure you clean up any references to the binding class instance in the fragment's onDestroyView() method.
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentBlankBinding = null;
    }
}