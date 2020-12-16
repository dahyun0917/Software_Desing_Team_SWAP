package com.example.schedule;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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
        adt.addItem("대구");
        adt.addItem("부산");
        adt.addItem("서울");
        adt.addItem("구미");
        adt.addItem("경주");
        adt.addItem("동해");
        adt.addItem("안동");
        adt.addItem("평양");
        recyclerView.setAdapter(adt);

        adt.setOnItemClicklistener(new OnLocationItemClickListener() {
            @Override
            public void onItemClick(adapter.ItemViewHolder holder, View view, int position) {
                String departure = adt.getItem(position);
                Toast.makeText(getLocation.this, departure, Toast.LENGTH_SHORT).show();
            }
        });





    }

}
