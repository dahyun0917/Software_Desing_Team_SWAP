package com.example.schedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public String date = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        date = "";



        Button departureButton = (Button) findViewById(R.id.bt_departure);
        Button dateButton = (Button)findViewById(R.id.bt_date);
        Button referButton = (Button)findViewById(R.id.bt_refer);
        dateButton.setText(date);

        departureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), getLocation.class);
                startActivity(intent);
            }
        });


        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), getDate.class);

                startActivity(intent);
                //Bundle bundle = intent.getExtras();
              //  if(bundle.getString("Date") != null){
               //     date = bundle.getString("Date");
              //  }
            }
        });
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), getDate.class);

                startActivity(intent);
                //Bundle bundle = intent.getExtras();
                //  if(bundle.getString("Date") != null){
                //     date = bundle.getString("Date");
                //  }
            }
        });

        referButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), referSchedule.class);
                startActivity(intent);
                //Bundle bundle = intent.getExtras();
                //  if(bundle.getString("Date") != null){
                //     date = bundle.getString("Date");
                //  }
            }
        });

    }
}