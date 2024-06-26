package com.prithviraj.contatcsstoringapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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

public class AddContact extends AppCompatActivity {
    Button submit;
    TextView name,phone,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        submit=findViewById(R.id.submitContact);
        name=findViewById(R.id.Name);
        phone = findViewById(R.id.Number);
        email = findViewById(R.id.Email);
        MyDBHelper myDBHelper = new MyDBHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty())
                {
                    Toast.makeText(AddContact.this, "Please enter Name", Toast.LENGTH_SHORT).show();
                } else if (phone.getText().toString().isEmpty()) {
                    Toast.makeText(AddContact.this, "Please enter Phone Number", Toast.LENGTH_SHORT).show();
                } else if (email.getText().toString().isEmpty()) {
                    Toast.makeText(AddContact.this, "Please enter Email ID", Toast.LENGTH_SHORT).show();
                }
                else {
                    myDBHelper.addContact(name.getText().toString(),phone.getText().toString(),email.getText().toString());
                    Intent myIntent = new Intent(AddContact.this,MainActivity.class);
                    AddContact.this.startActivity(myIntent);
                    Toast.makeText(AddContact.this, "Contact has been Added Successfully", Toast.LENGTH_LONG).show();

                }

            }
        });

    }
}