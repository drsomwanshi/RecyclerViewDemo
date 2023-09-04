package com.example.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    String img[];
    String name[];
    String contact[];

    public CustomAdapter(String img[],String name[],String contact[])
    {
        this.img=img;
        this.name=name;
        this.contact=contact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(name[position]);
        holder.txtContact.setText(contact[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public  ImageView imageView;
        public   TextView txtName;
        public  TextView txtContact;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img1);
            txtName=itemView.findViewById(R.id.txt1);
            txtContact=itemView.findViewById(R.id.txt2);
        }
    }

}
