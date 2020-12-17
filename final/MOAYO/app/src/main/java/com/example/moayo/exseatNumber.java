package com.example.moayo;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class exseatNumber extends AppCompatActivity {
    private static final String TAG = "exseatNumber";

    ImageButton button[] = new ImageButton[28];
    public int yn[] = new int[28];
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seatnumber);
        tv = findViewById(R.id.textView);
        this.asset();
        this.InitializeView();
        for (int i = 0; i < 28; i++) {
            if (yn[i] == 0) {
                button[i].setImageResource(R.drawable.xx);
            }
        }
    }
    public void InitializeView() {
        button[0] = (ImageButton) findViewById(R.id.iButton1);
        button[1] = (ImageButton) findViewById(R.id.iButton2);
        button[2] = (ImageButton) findViewById(R.id.iButton3);
        button[3] = (ImageButton) findViewById(R.id.iButton4);
        button[4] = (ImageButton) findViewById(R.id.iButton5);
        button[5] = (ImageButton) findViewById(R.id.iButton6);
        button[6] = (ImageButton) findViewById(R.id.iButton7);
        button[7] = (ImageButton) findViewById(R.id.iButton8);
        button[8] = (ImageButton) findViewById(R.id.iButton9);
        button[9] = (ImageButton) findViewById(R.id.iButton10);
        button[10] = (ImageButton) findViewById(R.id.iButton11);
        button[11] = (ImageButton) findViewById(R.id.iButton12);
        button[12] = (ImageButton) findViewById(R.id.iButton13);
        button[13] = (ImageButton) findViewById(R.id.iButton14);
        button[14] = (ImageButton) findViewById(R.id.iButton15);
        button[15] = (ImageButton) findViewById(R.id.iButton16);
        button[16] = (ImageButton) findViewById(R.id.iButton17);
        button[17] = (ImageButton) findViewById(R.id.iButton18);
        button[18] = (ImageButton) findViewById(R.id.iButton19);
        button[19] = (ImageButton) findViewById(R.id.iButton20);
        button[20] = (ImageButton) findViewById(R.id.iButton21);
        button[21] = (ImageButton) findViewById(R.id.iButton22);
        button[22] = (ImageButton) findViewById(R.id.iButton23);
        button[23] = (ImageButton) findViewById(R.id.iButton24);
        button[24] = (ImageButton) findViewById(R.id.iButton25);
        button[25] = (ImageButton) findViewById(R.id.iButton26);
        button[26] = (ImageButton) findViewById(R.id.iButton27);
        button[27] = (ImageButton) findViewById(R.id.iButton28);

        for (int i = 0; i < 28; i++) {
            button[i].setOnClickListener(onClickListener);
        }

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.iButton1:
                        setseatNum(1);
                        break;
                    case R.id.iButton2:
                        setseatNum(2);
                        break;
                    case R.id.iButton3:
                        setseatNum(3);
                        break;
                    case R.id.iButton4:
                        setseatNum(4);
                        break;
                    case R.id.iButton5:
                        setseatNum(5);
                        break;
                    case R.id.iButton6:
                        setseatNum(6);
                        break;
                    case R.id.iButton7:
                        setseatNum(7);
                        break;
                    case R.id.iButton8:
                        setseatNum(8);
                        break;
                    case R.id.iButton9:
                        setseatNum(9);
                        break;
                    case R.id.iButton10:
                        setseatNum(10);
                        break;
                    case R.id.iButton11:
                        setseatNum(1);
                        break;
                    case R.id.iButton12:
                        setseatNum(12);
                        break;
                    case R.id.iButton13:
                        setseatNum(13);
                        break;
                    case R.id.iButton14:
                        setseatNum(14);
                        break;
                    case R.id.iButton15:
                        setseatNum(15);
                        break;
                    case R.id.iButton16:
                        setseatNum(16);
                        break;
                    case R.id.iButton17:
                        setseatNum(17);
                        break;
                    case R.id.iButton18:
                        setseatNum(18);
                        break;
                    case R.id.iButton19:
                        setseatNum(19);
                        break;
                    case R.id.iButton20:
                        setseatNum(20);
                        break;
                    case R.id.iButton21:
                        setseatNum(21);
                        break;
                    case R.id.iButton22:
                        setseatNum(22);
                        break;
                    case R.id.iButton23:
                        setseatNum(23);
                        break;
                    case R.id.iButton24:
                        setseatNum(24);
                        break;
                    case R.id.iButton25:
                        setseatNum(25);
                        break;
                    case R.id.iButton26:
                        setseatNum(26);
                        break;
                    case R.id.iButton27:
                        setseatNum(27);
                        break;
                    case R.id.iButton28:
                        setseatNum(28);
                        break;
                }

            }

            private void setseatNum(int i) {
                if(yn[i-1]==1){
                    yn[i]=0;
                    FirebaseFirestore db = FirebaseFirestore.getInstance();
                    String seatnum = Integer.toString(i);
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
                                    DocumentReference seatnumRef = db.collection("users").document(finaluserId);
                                    seatnumRef
                                            .update("seatNumber", seatnum)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    Log.d(TAG, "DocumentSnapshot added with ID:" + seatnumRef.getId());
                                                    finish();
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    Log.w(TAG, "Error adding document", e);
                                                }
                                            });
                                  myStartActivity(paymentActivity.class);
                                } else {
                                    Log.d(TAG, "No such document");
                                }
                            } else {
                                Log.d(TAG, "get failed with ", task.getException());
                            }
                        }
                    });

                }else{
                    startToast("이미 예약된 좌석입니다. 다시 선택해주세요.");
                }
            }


        };
    private void myStartActivity(Class c){
        Intent intent=new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void asset() {
        AssetManager assetMgr = getAssets();

        int m = (int) (Math.random() * 10)+1;
        String st = "jsons/"+String.valueOf(m);
        try {
            InputStream is = assetMgr.open(st);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            StringBuffer buffer = new StringBuffer();
            String line = reader.readLine();
            while (line != null) {
                buffer.append(line + "\n");
                line = reader.readLine();
            }

            String jsonData = buffer.toString();
            JSONObject json = new JSONObject(jsonData);

            JSONObject js = new JSONObject(json.getString("response"));
            JSONArray jArr=new JSONArray(js.getString("seat_list"));
            String btn[]=new String[jArr.length()];
            String y=new String("Y");
            for (int i = 0; i < jArr.length(); i++) {
                btn[i]=jArr.getJSONObject(i).getString(String.valueOf(i+1)).toString();
                System.out.println(btn[i]);
                if (btn[i].equals(y))
                    yn[i] = 1;
                else
                    yn[i] = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void startToast(String msg){
        Toast.makeText( this ,msg,Toast.LENGTH_SHORT).show();
    }
}