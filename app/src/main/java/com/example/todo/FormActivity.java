package com.example.todo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.todo.model.Todo;

import java.io.Serializable;

public class FormActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.form_activity_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Create new Todo");

       Button button = findViewById(R.id.button);

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = getIntent();
               Todo todo = (Todo) intent.getSerializableExtra("todo");
               Log.d("item",todo.toString());

               setResult(5,intent);
               finish();
           }
       });



    }
}
