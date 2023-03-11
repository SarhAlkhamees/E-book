package com.example.assignment2_sarh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    Button insert, retrive;
    EditText authorname,booktitle,bookcate;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert= (Button)findViewById(R.id.insert);
        retrive=(Button) findViewById(R.id.retrive);
        authorname=(EditText) findViewById(R.id.authorname);
        booktitle=(EditText) findViewById(R.id.booktitle);
        bookcate=(EditText) findViewById(R.id.bookcate);
        reff = FirebaseDatabase.getInstance().getReference();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertData();
            }
        });

        retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Booklist.class));
                finish();
            }
        });

    }

    private void InsertData() {
        String Authorname = authorname.getText().toString();
        String Booktitle = booktitle.getText().toString();
        String Bookcate = bookcate.getText().toString();
        String id= reff.push().getKey();

        Book book = new Book(Authorname,Booktitle,Bookcate);
        reff.child("Book").child(id).setValue(book)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(MainActivity.this,"Book Details Inserted",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}