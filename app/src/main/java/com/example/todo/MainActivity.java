package com.example.todo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.todo.dao.RoomTodoDao;
import com.example.todo.dao.TodoDao;
import com.example.todo.model.Todo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    final TodoDao todoDao = new RoomTodoDao();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity_launcher);
        setTitle("Todos");
        FloatingActionButton button = findViewById(R.id.floatingActionButton);

        ListView lista = findViewById(R.id.listview);
        ArrayAdapter<Todo> arrayAdapter =  new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, todoDao.findAll());
        lista.setAdapter(arrayAdapter);


        button.setOnClickListener((View view) -> {
            //todoDao.save(new Todo("aaaa","oi","b"));

           // arrayAdapter.notifyDataSetChanged();
           //arrayAdapter.remove();

            Intent intent = new Intent(MainActivity.this,FormActivity.class);
            intent.putExtra("todo",new Todo("aaaa","oi","b"));
            startActivityForResult(intent, 5);

        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 5) {
              if(resultCode == 5){
                  Log.d("dados retornados",data.getSerializableExtra("todo").toString());
              }
        }
    }
}
