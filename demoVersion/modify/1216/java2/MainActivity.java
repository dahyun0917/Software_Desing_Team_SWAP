package com.example.schedule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public String depart = new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button departureButton = (Button) findViewById(R.id.bt_departure);
        departureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), getLocation.class);
                startActivity(intent);
            }
        });

        Button arrivalButton = (Button) findViewById(R.id.bt_arrival);
        arrivalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), getLocation.class);
                startActivity(intent);
            }
        });

        Button dateButton = (Button) findViewById(R.id.bt_date);
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), getDate.class);
                startActivity(intent);
            }
        });

        Intent returnIntent = getIntent();
        depart = returnIntent.getStringExtra("departure");
        TextView text_departure = (TextView) findViewById(R.id.text_departure);
        text_departure.setText(depart);




    }
}