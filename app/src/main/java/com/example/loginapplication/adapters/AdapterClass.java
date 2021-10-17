package com.example.loginapplication.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginapplication.models.ModelClass;
import com.example.loginapplication.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.ViewHolder> {
    private ArrayList<ModelClass> userList;
    private ViewHolder.RecyclerViewClickListener clickListener;

    public AdapterClass(ArrayList<ModelClass> userList, ViewHolder.RecyclerViewClickListener clickListener) {
        this.userList = userList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public AdapterClass.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_template, parent, false);
        return new ViewHolder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterClass.ViewHolder holder, int position) {
        String name, town;
        int photo;

        name = userList.get(position).getName();
        town = userList.get(position).getTown();
        photo = userList.get(position).getPhoto();

        holder.tv_name.setText(name);
        holder.tv_town.setText(town);
        holder.img_user.setImageResource(photo);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tv_name, tv_town;
        private CircleImageView img_user;
        RecyclerViewClickListener clickList;

        public ViewHolder(@NonNull View itemView, RecyclerViewClickListener clickListener) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_town = itemView.findViewById(R.id.tv_town);
            img_user = itemView.findViewById(R.id.imageView_user_profile);
            clickList = clickListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            clickList.onClickListener(getAdapterPosition());
        }

        public interface RecyclerViewClickListener {
            void onClickListener(int position);
        }
    }
}
