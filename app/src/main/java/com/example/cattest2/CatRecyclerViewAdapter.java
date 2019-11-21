package com.example.cattest2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CatRecyclerViewAdapter extends RecyclerView.Adapter<CatViewHolder> {
    private List<CatData> catData;

    public CatRecyclerViewAdapter(List<CatData> catData) {
        this.catData = catData;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_listitem, parent, false);
        CatViewHolder vh = new CatViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        catData.get(position);

        String catText = catData.get(position).getText();
        holder.getCatText().setText(catText);
    }

    @Override
    public int getItemCount() {
        return catData.size();
    }
}
