package com.example.c0772144_ex6;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c0772144_ex6.activities.AttractionDetailsActivity;
import com.example.c0772144_ex6.model.CanadaAttraction;

import java.io.Serializable;
import java.util.ArrayList;

public class AdapterActivity extends RecyclerView.Adapter<AdapterActivity.AttractionsViewHolder> {

    private ArrayList<CanadaAttraction> attractionArrayList;

    public AdapterActivity(ArrayList<CanadaAttraction> attractionArrayList) {
        this.attractionArrayList = attractionArrayList;
    }

    @NonNull
    @Override
    public AttractionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list
                        , parent
                        , false);
        AttractionsViewHolder mAttractionsViewHolder = new AttractionsViewHolder(mView);
        return mAttractionsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AttractionsViewHolder holder, final int position) {
        CanadaAttraction canadaAttraction = this.attractionArrayList.get(position);
        holder.txtAttractions.setText(canadaAttraction.getName());
        holder.imgAttractions.setImageResource(canadaAttraction.getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CanadaAttraction attraction = attractionArrayList.get(position);

                Intent attractionIntent = new Intent(holder.itemView.getContext(), AttractionDetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("attractionsKey", (Serializable) attraction);
                attractionIntent.putExtras(bundle);
                holder.itemView.getContext().startActivity(attractionIntent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return this.attractionArrayList.size();
    }

    public class AttractionsViewHolder extends RecyclerView.ViewHolder {
        TextView txtAttractions;
        ImageView imgAttractions;

        public AttractionsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAttractions = itemView.findViewById(R.id.txtAttraction);
            imgAttractions = itemView.findViewById(R.id.imgAttraction);
        }
    }
}