package com.prithviraj.contatcsstoringapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DelContact extends AppCompatActivity {
    TextView delPhone;
    Button delSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_del_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        delSubmit = findViewById(R.id.delsubmitContact);
        delPhone = findViewById(R.id.DelPhone);
        MyDBHelper myDBHelper = new MyDBHelper(this);
        delSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(delPhone.getText().toString().isEmpty())
                {
                    Toast.makeText(DelContact.this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
                }
                else{
                    myDBHelper.delContact(delPhone.getText().toString());
                    Intent myIntent = new Intent(DelContact.this,MainActivity.class);
                    DelContact.this.startActivity(myIntent);
                    Toast.makeText(DelContact.this, "Contact has been Deleted Successfully", Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}