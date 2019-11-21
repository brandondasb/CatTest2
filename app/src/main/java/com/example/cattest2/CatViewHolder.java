package com.example.cattest2;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CatViewHolder extends RecyclerView.ViewHolder {
    private TextView catText;
    public CatViewHolder(@NonNull View itemView) {
        super(itemView);
        this.catText = itemView.findViewById(R.id.cat_textview);

    }

    public TextView getCatText() {
        return catText;
    }
}
