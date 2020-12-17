package com.example.moayo;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class busSchedule extends AppCompatActivity {
    private static final String TAG = "busSchedule";
    public String date = new String();
    public String depart = new String();
    public String arrive = new String();
    public String dateToString = new String();
    public String departToString = new String();
    public String arriveToString = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busschedule);
        Intent recieveIntent = getIntent();
        date = recieveIntent.getStringExtra("date");
        dateToString = getIntent().getStringExtra("date");
        depart = recieveIntent.getStringExtra("depart");
        departToString = getIntent().getStringExtra("depart");
        arrive = recieveIntent.getStringExtra("arrive");
        arriveToString = getIntent().getStringExtra("arrive");
        TextView text_departure = (TextView) findViewById(R.id.text_departure);
        TextView text_arrive = (TextView) findViewById(R.id.text_arrival);
        TextView textDate = findViewById(R.id.textDateRefer);

        text_departure.setText(depart);
        text_arrive.setText(arrive);
        textDate.setText(date);

        Button dateButton = (Button)findViewById(R.id.bt_date);
        Button referButton = (Button)findViewById(R.id.bt_refer);



        Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Button departureButton = (Button) findViewById(R.id.bt_departure);
        departureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), getLocation.class);
                startActivityForResult(intent, 3000);
            }
        });

        Button arrivalButton = (Button) findViewById(R.id.bt_arrival);
        arrivalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), getLocationArrive.class);
                startActivityForResult(intent, 2000);
            }
        });

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), getDate.class);
                startActivityForResult(intent, 1000);
            }
        });

        referButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(date+ "/"+depart +"/"+arrive);
                if(dateToString !=null && departToString !=null && arriveToString != null ){
                    setDestination();
                    Intent intent = new Intent(getApplicationContext(), referSchedule.class);
                    intent.putExtra("Date", dateToString);
                    startActivity(intent);
                }else{
                    startToast("출발지,도착지, 날짜를 입력해주세요 ");
                }
            }
        });

    }
    private void setDestination() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference useridRef = db.collection("users").document("userDataId");
        useridRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String finaluserId = null;
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        String a = document.getData().toString();
                        finaluserId = a.substring(a.indexOf("=") + 1, a.length() - 1);
                        DocumentReference destinationRef = db.collection("users").document(finaluserId);
                        destinationRef
                                .update("departureLocation", departToString)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "DocumentSnapshot added with ID:" + destinationRef.getId());
                                        finish();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.w(TAG, "Error adding document", e);
                                    }
                                });
                        destinationRef
                                .update("arrivalLocation",arriveToString);
                        destinationRef
                                .update("date",dateToString);
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView text_departure = (TextView) findViewById(R.id.text_departure);
        TextView text_arrive = (TextView) findViewById(R.id.text_arrival);
        TextView textDate = findViewById(R.id.textDateRefer);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                // MainActivity 에서 요청할 때 보낸 요청 코드 (3000)
                case 3000:
                    text_departure.setText(data.getStringExtra("depart"));
                    departToString = (String) text_departure.getText();
                    break;
                case 2000:
                    text_arrive.setText(data.getStringExtra("arrive"));
                    arriveToString = (String) text_arrive.getText();
                    break;
                case 1000:
                    textDate.setText(data.getStringExtra("Date"));
                    dateToString = (String) textDate.getText();
                    break;

            }
        }
    }
    private void startToast(String msg){
        Toast.makeText( this ,msg,Toast.LENGTH_SHORT).show();
    }
}