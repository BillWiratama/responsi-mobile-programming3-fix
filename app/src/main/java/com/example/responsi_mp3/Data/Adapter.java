package com.example.responsi_mp3.Data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.responsi_mp3.Model.Laptop;
import com.example.responsi_mp3.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ListViewHolder> {

    private final ArrayList<Laptop> listlaptop;
    private OnItemClickCallback onItemClickCallback;


    public Adapter(ArrayList<Laptop> listlaptop) {
        this.listlaptop = listlaptop;

    }

    @NonNull
    @NotNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_laptop, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListViewHolder holder, int position) {
        Laptop laptop = listlaptop.get(position);
        Glide.with(holder.itemView.getContext())
                .load(laptop.getImage())
                .apply(new RequestOptions())
                .into(holder.img_iphone);
        holder.name.setText(laptop.getLaptop_name());
        holder.type.setText(laptop.getType());
        holder.price.setText(laptop.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listlaptop.get(holder.getAdapterPosition()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return listlaptop.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView img_iphone;
        TextView name, type, price;

        public ListViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            img_iphone = itemView.findViewById(R.id.img_iphone);
            name = itemView.findViewById(R.id.laptop_name);
            type = itemView.findViewById(R.id.type_laptop);
            price = itemView.findViewById(R.id.price);


        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Laptop data);
    }
}