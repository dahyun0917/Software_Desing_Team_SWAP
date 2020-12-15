package com.example.schedule;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class getLocation extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location_refine);
        /*location l = new location();

        Button b1 = (Button)findViewById(R.id.button13);
        b1.setText(l.loc[0]);

        Button b2 = (Button)findViewById(R.id.button14);
        b2.setText(l.loc[1]);

        Button b3 = (Button)findViewById(R.id.button15);
        b3.setText(l.loc[2]);

        Button b4 = (Button)findViewById(R.id.button16);
        b4.setText(l.loc[3]);

        Button b5 = (Button)findViewById(R.id.button17);
        b5.setText(l.loc[4]);

        Button b6 = (Button)findViewById(R.id.button18);
        b6.setText(l.loc[5]);

        Button b7 = (Button)findViewById(R.id.button19);
        b7.setText(l.loc[6]);*/

        String[] arr1 = new String[7];

        String[] loc = {"동대구","부산","서울","포항","구미","동해","경주"};

        RecyclerView recyclerView = findViewById(R.id.recycler1);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter adt = new adapter();
        adt.addItem("대구");
        adt.addItem("부산");
        recyclerView.setAdapter(adt);


    }
}
