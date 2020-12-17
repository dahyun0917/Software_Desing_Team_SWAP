package com.example.schedule;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class getLocation extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location_refine);

        RecyclerView recyclerView = findViewById(R.id.recycler1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter adt = new adapter();
        adt.addItem(new location("대구"));
        adt.addItem(new location("부산"));
        adt.addItem(new location("서울"));
        adt.addItem(new location("구미"));
        adt.addItem(new location("경주"));
        recyclerView.setAdapter(adt);


    }
}