package com.example.moayo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class checkAndChange extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_change);
        TextView text_departureLocation =(TextView) findViewById(R.id.departureLocationText2);
        TextView text_arrivalLocation = (TextView)findViewById(R.id.arrivalLocationText2);
        TextView text_departureTime =(TextView) findViewById(R.id.departureTimeText2);
        TextView text_arrivalTime = (TextView)findViewById(R.id.arrivalTimeText2);
        TextView text_bustype = (TextView)findViewById(R.id.bustypeText2);
        findViewById(R.id.button_change).setOnClickListener(onClickListener);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference useridRef = db.collection("users").document("userDataId");

        useridRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String finaluserId = null;
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String a = document.getData().toString();
                        finaluserId = a.substring(a.indexOf("=") + 1, a.length() - 1);
                        DocumentReference userinfoRef = db.collection("users").document(finaluserId);
                        userinfoRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task2) {
                                DocumentSnapshot document2 = task2.getResult();
                                if (document2.exists()) {
                                    text_departureLocation.setText(document2.get("departureLocation").toString());
                                    text_arrivalLocation.setText(document2.get("arrivalLocation").toString());
                                    text_bustype.setText(document2.get("bus type").toString());
                                    text_departureTime.setText(document2.get("departure time").toString());
                                    text_arrivalTime.setText(document2.get("arrival time").toString());
                                }
                            }
                        });
                    }
                }
            }
        });
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            myStartActivity(busSchedule.class);
        }
    };
    private void myStartActivity(Class c){
        Intent intent=new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

