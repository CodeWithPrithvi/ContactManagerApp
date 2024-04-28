package com.prithviraj.contatcsstoringapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    Context context;
    ArrayList<contact> contacts=new ArrayList<contact>();

    public MyAdapter(Context context, ArrayList<contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.contactsdisplay,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView1.setText(contacts.get(position).getuName());
        holder.textView2.setText(contacts.get(position).getuNumber());
        holder.textView3.setText(contacts.get(position).getuEmail());


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
