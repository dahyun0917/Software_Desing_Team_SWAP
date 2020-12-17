package com.example.moayo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class referSchedule<calendarView> extends AppCompatActivity {
    /*추천노선*/
    public busInfo businfos[] = new busInfo[10];
    public int diffCharge;
    public int diffTimeCity, diffTimeExpress;
    public String resultMassageCharge = new String();
    public String resultMassageTime = new String();
    public String date = new String();
    public int count;
    //Context context;
    TextView[] selText = new TextView[10];
    TextView[] dptText = new TextView[10];
    TextView[] arvText = new TextView[10];
    TextView[] grdText = new TextView[10];
    /*추천노선*/
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refer_schedule);
        findViewById(R.id.backButton).setOnClickListener(onClickListener);
        EditText dateText = findViewById(R.id.textDateRefer);
        Intent getInfo = getIntent();
        date = getInfo.getStringExtra("Date");
        dateText.setText(date);

        selText[0] = (TextView) findViewById(R.id.ticket1);
        selText[1] = (TextView) findViewById(R.id.ticket2);
        selText[2] = (TextView) findViewById(R.id.ticket3);
        selText[3] = (TextView) findViewById(R.id.ticket4);
        selText[4] = (TextView) findViewById(R.id.ticket5);
        selText[5] = (TextView) findViewById(R.id.ticket6);
        selText[6] = (TextView) findViewById(R.id.ticket7);
        selText[7] = (TextView) findViewById(R.id.ticket8);
        selText[8] = (TextView) findViewById(R.id.ticket9);
        selText[9] = (TextView) findViewById(R.id.ticket10);
        Intent intent = new Intent(this, exseatNumber.class);
        for(count = 0; count < 10; count++) {
            selText[count].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = intent.getExtras();
                    switch(v.getId()){
                        case R.id.ticket1:
                            setBusSchedule(0);
                            myStartActivity(exseatNumber.class);
                            break;
                        case R.id.ticket2:
                            setBusSchedule(1);
                            myStartActivity(exseatNumber.class);
                            break;
                        case R.id.ticket3:
                            setBusSchedule(2);
                            myStartActivity(exseatNumber.class);
                            break;
                        case R.id.ticket4:
                            setBusSchedule(3);
                            myStartActivity(exseatNumber.class);
                            break;
                        case R.id.ticket5:
                            setBusSchedule(4);
                            myStartActivity(exseatNumber.class);
                            break;
                        case R.id.ticket6:
                            setBusSchedule(5);
                            myStartActivity(exseatNumber.class);
                            break;
                        case R.id.ticket7:
                            setBusSchedule(6);
                            myStartActivity(exseatNumber.class);
                            break;
                        case R.id.ticket8:
                            setBusSchedule(7);
                            myStartActivity(exseatNumber.class);
                            break;
                        case R.id.ticket9:
                            setBusSchedule(8);
                            myStartActivity(exseatNumber.class);
                            break;
                        case R.id.ticket10:
                            setBusSchedule(9);
                            myStartActivity(exseatNumber.class);
                    }
                    myStartActivity(exseatNumber.class);
                }
            });
        }

        /*추천 노선 코드*/
        businfos[0] = new busInfo("경주", "동대구", "6500", "0730", "0820", "고속");
        businfos[1] = new busInfo("경주", "동대구", "5600", "0740", "0830", "시외");
        businfos[2] = new busInfo("경주", "동대구", "5600", "0800", "0855", "시외");
        businfos[3] = new busInfo("경주", "동대구", "5600", "0820", "0915", "시외");
        businfos[4] = new busInfo("경주", "동대구", "6500", "0820", "0910", "고속");
        businfos[5] = new busInfo("경주", "동대구", "5600", "0840", "0935", "시외");
        businfos[6] = new busInfo("경주", "동대구", "5600", "0900", "0955", "시외");
        businfos[7] = new busInfo("경주", "동대구", "6500", "0900", "0950", "고속");
        businfos[8] = new busInfo("경주", "동대구", "5600", "0920", "1015", "시외");
        businfos[9] = new busInfo("경주", "동대구", "6500", "0940", "1030", "고속");



        recommendSchedule(businfos[2], businfos[5]);


        /*추천 노선 코드*/

        /*티켓정보*/
        dptText[0] = (TextView)findViewById(R.id.dptView1);
        dptText[1] = (TextView)findViewById(R.id.dptView2);
        dptText[2] = (TextView)findViewById(R.id.dptView3);
        dptText[3] = (TextView)findViewById(R.id.dptView4);
        dptText[4] = (TextView)findViewById(R.id.dptView5);
        dptText[5] = (TextView)findViewById(R.id.dptView6);
        dptText[6] = (TextView)findViewById(R.id.dptView7);
        dptText[7] = (TextView)findViewById(R.id.dptView8);
        dptText[8] = (TextView)findViewById(R.id.dptView9);
        dptText[9] = (TextView)findViewById(R.id.dptView10);
        for(int i = 0; i < 10; i++){
            dptText[i].setText(businfos[i].getDptTime());
        }
        arvText[0] = (TextView)findViewById(R.id.ticket1);
        arvText[1] = (TextView)findViewById(R.id.ticket2);
        arvText[2] = (TextView)findViewById(R.id.ticket3);
        arvText[3] = (TextView)findViewById(R.id.ticket4);
        arvText[4] = (TextView)findViewById(R.id.ticket5);
        arvText[5] = (TextView)findViewById(R.id.ticket6);
        arvText[6] = (TextView)findViewById(R.id.ticket7);
        arvText[7] = (TextView)findViewById(R.id.ticket8);
        arvText[8] = (TextView)findViewById(R.id.ticket9);
        arvText[9] = (TextView)findViewById(R.id.ticket10);
        for(int i = 0; i < 10; i++){
            arvText[i].setText(businfos[i].getArrTime());
        }

        grdText[0] = (TextView)findViewById(R.id.busGrade1);
        grdText[1] = (TextView)findViewById(R.id.busGrade2);
        grdText[2] = (TextView)findViewById(R.id.busGrade3);
        grdText[3] = (TextView)findViewById(R.id.busGrade4);
        grdText[4] = (TextView)findViewById(R.id.busGrade5);
        grdText[5] = (TextView)findViewById(R.id.busGrade6);
        grdText[6] = (TextView)findViewById(R.id.busGrade7);
        grdText[7] = (TextView)findViewById(R.id.busGrade8);
        grdText[8] = (TextView)findViewById(R.id.busGrade9);
        grdText[9] = (TextView)findViewById(R.id.busGrade10);
        for(int i = 0; i < 10; i++){
            grdText[i].setText(businfos[i].getBusGrade());
        }

        /*티켓정보*/
    }

    private void recommendSchedule(busInfo exInfo, busInfo ctInfo){
        TextView departText1 = (TextView)findViewById(R.id.dptText);
        TextView arrivalText1 = (TextView)findViewById(R.id.arvText);

        departText1.setText("출발지\n\n" + ctInfo.getDptPlaceName());
        arrivalText1.setText("도착지\n\n" + ctInfo.getArrPlaceName());
        diffCharge = Integer.parseInt(exInfo.getCharge()) - Integer.parseInt(ctInfo.getCharge());
        diffTimeCity = Integer.parseInt(ctInfo.getArrTime()) - Integer.parseInt(ctInfo.getDptTime());

        diffTimeExpress = Integer.parseInt(exInfo.getArrTime()) - Integer.parseInt(exInfo.getDptTime());
        if(diffTimeCity <= diffTimeExpress){
            resultMassageTime = "시간 기준\n\n" + "시외버스\n" + "요금: " + ctInfo.getCharge() + "\n" + "소요시간: " + diffTimeCity + "분";
        }
        else{
            resultMassageTime = "시간 기준\n\n" +"고속버스\n" + "요금: " + exInfo.getCharge() + "\n" + "소요시간: " + diffTimeExpress + "분";
        }
        if(diffCharge >= 0){
            resultMassageCharge = "요금 기준\n\n" +"시외버스\n" + "요금: " + ctInfo.getCharge() + "\n" + "소요시간: " + diffTimeCity + "분";
        }
        else{
            resultMassageCharge = "요금 기준\n\n" + "고속버스\n" + "요금: " + exInfo.getCharge() + "\n" + "소요시간: " + diffTimeExpress + "분";
        }
        TextView chargeText = (TextView)findViewById(R.id.chargeRecommend);
        chargeText.setText(resultMassageCharge);
        TextView timeText = (TextView)findViewById(R.id.timeRecommend);
        timeText.setText(resultMassageTime);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.backButton:
                    gotoMainActivity();
                    break;

            }

        }
    };
    private void setBusSchedule(int i) {
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
                        DocumentReference destinationRef = db.collection("users").document(finaluserId);
                        destinationRef
                                .update("departureLocation", businfos[i].dptPlaceName);
                        destinationRef
                                .update("arrivalLocation", businfos[i].arrPlaceName);
                        destinationRef
                                .update("amount", businfos[i].charge);
                        destinationRef
                                .update("departure time", businfos[i].dptTime);
                        destinationRef
                                .update("arrival time", businfos[i].arrTime);
                        destinationRef
                                .update("bus type", businfos[i].busGrade);
                    }
                }
            }
        });
    }
    private void gotoMainActivity(){
        Intent intent = new Intent(this, busSchedule.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    private void myStartActivity(Class c){
        Intent intent=new Intent(this, c);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}