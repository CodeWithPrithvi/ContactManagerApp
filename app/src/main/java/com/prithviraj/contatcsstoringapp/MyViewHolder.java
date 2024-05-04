package com.prithviraj.contatcsstoringapp;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    LinearLayout linearLayout;
    TextView textView1;
    TextView textView2;
    TextView textView3;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        textView1 = itemView.findViewById(R.id.contactName);
        textView2 = itemView.findViewById(R.id.contactNumber);
        textView3 = itemView.findViewById(R.id.contactEmail);
        linearLayout = itemView.findViewById(R.id.llrow);
    }
}
