package com.example.moayo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class paymentActivity extends AppCompatActivity{
    private static final String TAG = "paymentActivity";
    private Intent intent1;
    private final String packageName ="com.kscc.xzz.mbl&hl=ko&gl=US";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        TextView text_amount = (TextView)findViewById(R.id.amountText);
        TextView text_departureLocation =(TextView) findViewById(R.id.departureLocationText);
        TextView text_arrivalLocation = (TextView)findViewById(R.id.arrivalLocationText);
        TextView text_seatNumber = (TextView)findViewById(R.id.seatNumberText);
        TextView text_departureTime =(TextView) findViewById(R.id.departureTimeText);
        TextView text_arrivalTime = (TextView)findViewById(R.id.arrivalTimeText);
        intent1 = this.getPackageManager().getLaunchIntentForPackage(packageName);
        findViewById(R.id.paymentBotton).setOnClickListener(onClickListener);
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
                        DocumentReference userinfoRef = db.collection("users").document(finaluserId);
                        userinfoRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task2) {
                                DocumentSnapshot document2 = task2.getResult();
                                if(document2.exists()){
                                    text_amount.setText(document2.get("amount").toString());
                                    text_departureLocation.setText(document2.get("departureLocation").toString());
                                    text_arrivalLocation.setText(document2.get("arrivalLocation").toString());
                                    text_seatNumber.setText(document2.get("seatNumber").toString());
                                    text_departureTime.setText(document2.get("departure time").toString());
                                    text_arrivalTime.setText(document2.get("arrival time").toString());
                                }
                            }
                        });
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.paymentBotton:
                    myStartActivity(MainActivity.class);
                    break;
            }
        }
    };
    private void myStartActivity(Class c){
        Intent intent=new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}

