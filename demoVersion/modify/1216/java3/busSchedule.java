package com.example.schedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class busSchedule extends AppCompatActivity {
    public String date = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busschedule);

        Intent recieveIntent = getIntent();
        date = recieveIntent.getStringExtra("Date");

        Button departureButton = (Button) findViewById(R.id.bt_departure);
        Button dateButton = (Button)findViewById(R.id.bt_date);
        Button referButton = (Button)findViewById(R.id.bt_refer);
        TextView textDate = findViewById(R.id.textDateRefer);
        textDate.setText(date);

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

        referButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), referSchedule.class);
                intent.putExtra("Date", date);
                startActivity(intent);
                //Bundle bundle = intent.getExtras();
                //  if(bundle.getString("Date") != null){
                //     date = bundle.getString("Date");
                //  }
            }
        });

    }
}