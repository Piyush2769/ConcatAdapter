package com.piyushmaheswari.concatadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerHorizontalAdapter extends RecyclerView.Adapter<RecyclerHorizontalAdapter.RecyclerCardViewHolder> {

    private ArrayList<String> imageUrls;
    private Context context;

    RecyclerHorizontalAdapter(ArrayList<String> imageUrls, Context context) {
        this.imageUrls = imageUrls;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item_recycler, viewGroup, false);
        return new RecyclerCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerCardViewHolder recyclerCardViewHolder, int i) {

        Glide.with(context)
                .asBitmap()
                .load(imageUrls.get(i))
                .into(recyclerCardViewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    static class RecyclerCardViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        RecyclerCardViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cardView);
        }
    }

}