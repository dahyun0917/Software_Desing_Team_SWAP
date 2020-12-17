package com.example.moayo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class getDate<calendarView> extends AppCompatActivity {
    public DatePicker datePicker;
    public String selectYear = new String();
    public String selectMonth = new String();
    public String selectDate = new String();
    public String Date = new String();
    //public Button buttonSelect;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        findViewById(R.id.ButtonSelect).setOnClickListener(onClickListener);
        datePicker = findViewById(R.id.dp);
        int year = 2020, month = 12, day = 16;
        selectYear = "" + year;
        selectMonth = "" + month;
        selectDate = "" + day;
        datePicker.init(year, month - 1, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                selectYear = "" + (year - 2000);
                if(monthOfYear > 9)
                    selectMonth = "" + (monthOfYear + 1);
                else
                    selectMonth = "0" + (monthOfYear + 1);

                if(dayOfMonth > 9)
                    selectDate = "" + dayOfMonth;
                else
                    selectDate = "0" + dayOfMonth;
                Date = selectYear + selectMonth + selectDate;
            }

        });
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.ButtonSelect:
                    Toast.makeText(getDate.this, (selectYear + " " + selectMonth + " " + selectDate), Toast.LENGTH_SHORT).show();
                    //gotoMainActivity();
                    Intent intent = new Intent();
                    Bundle bundle = intent.getExtras();
                    //String reDate = new String();
                    //reDate = data.getDate();
                    intent.putExtra("Date", Date.toString());
                    //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    //context.startActivity(intent);
                    setResult(RESULT_OK, intent);
                    finish();
                    break;
            }
        }
    };

    private void gotoMainActivity(){
        /*Intent intent = new Intent(this, busSchedule.class);
        Bundle bundle = intent.getExtras();
        intent.putExtra("Date", Date);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);*/

        Intent intent = new Intent();
        Bundle bundle = intent.getExtras();
        intent.putExtra("Date", Date);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //context.startActivity(intent);
        setResult(RESULT_OK, intent);
        finish();
    }


}