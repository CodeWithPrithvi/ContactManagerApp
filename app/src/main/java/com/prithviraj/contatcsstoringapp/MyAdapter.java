package com.prithviraj.contatcsstoringapp;

import static androidx.core.content.ContextCompat.startActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView1.setText(contacts.get(position).getuName());
        holder.textView2.setText(contacts.get(position).getuNumber());
        holder.textView3.setText(contacts.get(position).getuEmail());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.updare_layout);
                EditText editText1 = dialog.findViewById(R.id.updateName);
                EditText editText2 = dialog.findViewById(R.id.updatePhone);
                EditText editText3 = dialog.findViewById(R.id.updateEmail);
                Button button = dialog.findViewById(R.id.updatebtn);
                editText1.setText((contacts.get(position).getuName()));
                editText2.setText((contacts.get(position).getuNumber()));
                editText3.setText((contacts.get(position).getuEmail()));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MyDBHelper myDBHelper = new MyDBHelper(context);
                        String name,phone,email;
                        name = editText1.getText().toString();
                        phone=editText2.getText().toString();
                        email=editText3.getText().toString();
                        myDBHelper.updateContact(name,phone,email);
                        dialog.dismiss();
                        Intent i = new Intent(context, MainActivity.class);
                        context.startActivity(i);


                    }
                });
                dialog.show();

            }

        });


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
