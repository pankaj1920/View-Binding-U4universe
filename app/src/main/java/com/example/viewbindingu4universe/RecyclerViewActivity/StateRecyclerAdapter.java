package com.example.viewbindingu4universe.RecyclerViewActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.example.viewbindingu4universe.R;
import com.example.viewbindingu4universe.RecyclerViewActivity.covid.StateWise;
import com.example.viewbindingu4universe.databinding.RecycleMainListBinding;

import java.util.List;

public class StateRecyclerAdapter extends RecyclerView.Adapter<StateRecyclerAdapter.State_VH> {

    List<StateWise> stateWisesList;
    Context context;

    public StateRecyclerAdapter(List<StateWise> stateWisesList, Context context) {
        this.stateWisesList = stateWisesList;
        this.context = context;
    }


    @NonNull
    @Override
    public State_VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecycleMainListBinding listBinding = RecycleMainListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new State_VH(listBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull State_VH holder, int position) {
        StateWise stateWiseData = stateWisesList.get(position);

        holder.itemBinding.stateCode.setText(stateWiseData.getStatecode());
        holder.itemBinding.stateName.setText(stateWiseData.getState());



    }

    @Override
    public int getItemCount() {
        return stateWisesList.size();
    }



    class State_VH extends RecyclerView.ViewHolder{

        RecycleMainListBinding itemBinding;

        public State_VH( RecycleMainListBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;

        }
    }

}
